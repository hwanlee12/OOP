package Board;

import java.sql.*;
import java.util.Scanner;

public class Login {
    public String login (Connection con) {
        Scanner in = new Scanner(System.in);
        MD5 md5 = new MD5();

        String ID, Password;
        try {
            System.out.println("===============Login===============");
            System.out.print("ID >> ");
            ID = in.nextLine();
            System.out.print("Password >> ");
            Password = in.nextLine();

            PreparedStatement pstmt = con.prepareStatement("select user_lv.level, member.ID, member.Password " +
                    "from member inner join user_lv on member.ID = user_lv.ID where member.ID=?");
            pstmt.setString(1,ID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                String field1 = rs.getString("ID").trim();
                String field2 = rs.getString("Password").trim();
                int level = rs.getInt("Level");
                if(field1.equals(ID) && field2.equals(md5.testMD5(Password))) {
                    System.out.println("로그인");
                    System.out.printf("권한 레벨 %d\n", level);
                    return ID;
                }
                else
                    continue;
            }
            rs.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
        return "Login Error";
    }

    public int select_login(String ID, Connection con) {
        N_board board = new N_board();
        board.prtBoard(con);
        int select = 0;
        System.out.printf("사용자 : %s\n", ID);
        System.out.println("1. 글 작성");
        System.out.println("2. 글 삭제");
        System.out.println("3. 글 보기");
        System.out.println("4. 로그아웃");
        System.out.print(">>");

        while(true) {
            try{
                Scanner in = new Scanner(System.in);
                select = in.nextInt();
            }
            catch(Exception e) {
                Scanner in = new Scanner(System.in);
            }
            finally {
                if(select == 1) {
                    System.out.println();
                    board.wrtBoard(ID, con);
                    break;
                }
                else if(select == 2) {
                    System.out.println();
                    board.delBoard(ID, con);
                    break;
                }
                else if(select == 3) {
                    System.out.println();
                    board.show_contents(con);
                    break;
                }
                else if(select == 4) {
                    System.out.println("로그아웃");
                    break;
                }
                else if(select != 1 || select != 2 || select != 3 || select != 4) {
                    System.out.println("재입력");
                }
            }
        }
        System.out.println();
        return select;
    }
}
