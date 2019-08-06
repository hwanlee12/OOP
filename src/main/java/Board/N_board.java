package Board;

import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class N_board {
    public void prtBoard(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Board");
            while(rs.next()) {
                String field1 = rs.getString("Board_num");
                String field2 = rs.getString("User_ID");
                String field3 = rs.getString("Title");
                String field4 = rs.getString("Date");
                System.out.print(field1 + "\t");
                System.out.print(field2 + "\t");
                System.out.print(field3 + "\t");
                System.out.println(field4);
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }

    public void wrtBoard(String ID, Connection con) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try {
            Statement stmt = con.createStatement();
            String title;
            System.out.println("제목 입력");
            title = in.nextLine();

            String message = "";
            System.out.println("내용 입력");
            System.out.println("종료시 'quit'만 입력");
            while(in.hasNextLine()) {
                String[] tokens = in.nextLine().split("\\s");
                if(tokens.length == 1 && tokens[0].equals("quit")) {
                    System.out.println("입력 종료");
                    break;
                }
                for(int i = 0; i < tokens.length; i++) {
                    message += tokens[i] + " ";
                }
                message += "\n";
            }

            String sql = "insert into Board([User_ID], [Title], [Date], [Contents])";
            sql += " VALUES("+"'"+ID+"','"+title+"','"+ dateFormat.format(cal.getTime())+"','" +message+"')";
            stmt.executeUpdate(sql);
            stmt.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }

    public void show_contents(Connection con) {
        try {
            int title_num;
            int exist = 0;
            System.out.println("글 번호 입력");
            System.out.print(">>");
            Scanner in = new Scanner(System.in);
            title_num = in.nextInt();
            try {
                PreparedStatement pstmt = con.prepareStatement("select * from Board where Board_num=?");
                pstmt.setInt(1, title_num);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    exist = 1;
                    String field1 = rs.getString("Title").trim();
                    String field2 = rs.getString("Contents").trim();
                    int num = rs.getInt("Board_num");
                    if(exist == 1) {
                        System.out.println(field1);
                        System.out.println(field2);
                        break;
                    }
                }
            } catch (SQLException sqle) {
                System.out.println("SQLException : " + sqle);
            }

        }
        catch (Exception e) {
            System.out.println("재 입력");
            Scanner in = new Scanner(System.in);
        }
    }

    public void delBoard(String ID, Connection con) {
        Scanner in = new Scanner(System.in);
        int delete = 0;
        int user_level = 0;
        try {
            System.out.println("삭제할 글 번호 입력");
            System.out.print(">>");
            int title_num = in.nextInt();

            Statement stmt = con.createStatement();
            PreparedStatement pstmt1 = con.prepareStatement("select Level from user_lv where ID = ?");
            pstmt1.setString(1, ID);
            ResultSet user_info = pstmt1.executeQuery();
            while(user_info.next()){
                user_level = user_info.getInt("Level");
            }

            PreparedStatement pstmt = con.prepareStatement("select user_lv.Level, Board.User_ID, Board.Board_num " +
                    "from Board inner join user_lv on Board.User_ID = user_lv.ID " +
                    "where Board_num=?");
            pstmt.setInt(1,title_num);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                int field1 = rs.getInt("Board_num");
                String field2 = rs.getString("User_ID").trim();
                int field3 = rs.getInt("Level");
                String dump = in.nextLine();

                if(field3 < user_level) {
                    delete = 3;
                    break;
                }
                else if(field3 == user_level) {
                    if(field1 == title_num && field2.equals(ID)) {
                        System.out.println("삭제 하시겠습니까? Y/N");
                        System.out.print(">> ");
                        String yn = in.nextLine();
                        if(yn.equals("y") || yn.equals("Y")) {
                            String sql = "delete from Board WHERE Board_num="+title_num;
                            stmt.executeUpdate(sql);
                            delete = 1;
                            break;
                        }
                        else {
                            delete = 2;
                            break;
                        }
                    }
                    else {
                        delete = 4;
                    }
                }
                else {// field3 > user_level삭제 가능
                    if(field1 == title_num) {
                        System.out.println("삭제 하시겠습니까? Y/N");
                        System.out.print(">> ");
                        String yn = in.nextLine();
                        if(yn.equals("y") || yn.equals("Y")) {
                            String sql = "delete from Board WHERE Title="+"'"+title_num+"'";
                            stmt.executeUpdate(sql);
                            delete = 1;
                            break;
                        }
                        else {
                            delete = 2;
                            break;
                        }
                    }
                }
            }
            if (delete == 1) {
                System.out.println("삭제 완료");
            }
            else if (delete == 2) {
                System.out.println("삭제 안 함");
            }
            else if(delete == 3){
                System.out.println("권한 부족");
            }
            else if(delete == 4){
                System.out.println("글쓴이외 삭제 불가");
            }
            else {
                System.out.printf("%d이 존재하지 않음\n",title_num);
            }
            pstmt.close();
            stmt.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }
}
