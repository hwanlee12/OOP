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
        Scanner in = new Scanner(System.in);
        String title;
        System.out.println("제목 입력");
        System.out.print(">>");
        title = in.nextLine();
        try {
            PreparedStatement pstmt = con.prepareStatement("select * from Board where Title=?");
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String field1 = rs.getString("Title").trim();
                String field2 = rs.getString("Contents").trim();
                if (field1.equals(title)) {
                    System.out.println(field2);
                    break;
                }
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }

    public void delBoard(String ID, Connection con) {
        Scanner in = new Scanner(System.in);
        int delete = 0;
        try {
            Statement stmt = con.createStatement();
            System.out.println("삭제할 제목 입력");
            System.out.print(">>");
            String title = in.nextLine();
            ResultSet rs = stmt.executeQuery("select Title, User_ID from Board");
            while(rs.next()) {
                String field1 = rs.getString("Title").trim();
                String field2 = rs.getString("User_ID").trim();
                if(field1.equals(title) && field2.equals(ID)) {
                    String sql = "delete from Board WHERE Title="+"'"+title+"'";
                    stmt.executeUpdate(sql);
                    delete = 1;
                    break;
                }
                else
                    continue;
            }
            if (delete == 1) {
                System.out.println("삭제 완료");
            }
            else {
                System.out.println("글쓴이외 삭제 불가");
            }
            stmt.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }
}
