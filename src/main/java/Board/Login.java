package Board;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;

public class Login {
    public String login () throws ClassNotFoundException, NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        MD5 md5 = new MD5();

        String ID;
        String Password;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://192.168.120.19:1433;" +
                    "databaseName=pratice_j;user=testj;password=12345;";
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from member");

            System.out.println("===============Login===============");
            System.out.print("ID >> ");
            ID = in.nextLine();
            System.out.print("Password >> ");
            Password = in.nextLine();

            while(rs.next()) {
                String field1 = rs.getString("ID").trim();
                String field2 = rs.getString("Password").trim();
                if(field1.equals(ID) && field2.equals(md5.testMD5(Password))) {
                    System.out.println("login success");
                    return ID;
                }
                else
                    continue;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
        return "Login Error";
    }

    public int select_login(String ID) throws ClassNotFoundException{
        N_board board = new N_board();
        int select = 0;
        System.out.printf("사용자 : %s\n", ID);
        System.out.println("1. 글 작성");
        System.out.println("2. 글 삭제");
        System.out.println("3. 로그아웃");
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
                    board.prtBoard();
                    board.wrtBoard(ID);
                    break;
                }
                else if(select == 2) {
                    board.prtBoard();
                    board.delBoard(ID);
                }
                else if(select == 3) {
                    System.out.println("로그아웃");
                    break;
                }
                else if(select != 1 || select != 2 || select != 3) {
                    System.out.println("재입력");
                }
            }
        }
        return select;
    }
}
