package Board;

import org.w3c.dom.Text;

import java.sql.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class main {
    public static void main(String args[]) throws ClassNotFoundException
    {
        String ID = null;
        String Password = null;
        int select = 0;

        while(true) {
            try{
                Scanner in = new Scanner(System.in);
                select = in.nextInt();
            }
            catch(Exception e) {
                Scanner in = new Scanner(System.in);
            }
            finally {
                if(select == 1 || select == 2) {
                    break;
                }
                else if(select == 3) {
                    System.out.println("종료");
                    System.exit(0);
                }
                else if(select != 1 || select != 2) {
                    System.out.println("재입력");
                }
            }
        }

        Scanner in = new Scanner(System.in);
        switch(select) {
            case 1:
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String connectionUrl = "jdbc:sqlserver://192.168.120.19:1433;" +
                            "databaseName=pratice_j;user=testj;password=12345;";
                    Connection con = DriverManager.getConnection(connectionUrl);
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from member");

                    ID = in.nextLine();
                    Password = in.nextLine();

                    while(rs.next()) {
                        String field1 = rs.getString("ID").trim();
                        String field2 = rs.getString("Password").trim();
                        if(field1.equals(ID) && field2.equals(Password)) {
                            System.out.println("login success");
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

                break;

            case 2:
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String connectionUrl = "jdbc:sqlserver://192.168.120.19:1433;" +
                            "databaseName=pratice_j;user=testj;password=12345;";
                    Connection con = DriverManager.getConnection(connectionUrl);
                    Statement stmt = con.createStatement();

                    ID = in.nextLine();
                    Password = in.nextLine();

                    String sql = "insert into member(ID, Password)";
                    sql += " VALUES(" + "'"+ID+"', '"+Password+"')";
                    stmt.executeUpdate(sql);

                    stmt.close();
                    con.close();
                }
                catch (SQLException sqle) {
                    System.out.println("SQLException : " + sqle);
                }

                break;
        } // 회원가입과 로그인

        // 글쓰기 시작
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://192.168.120.19:1433;" +
                    "databaseName=pratice_j;user=testj;password=12345;";
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = con.createStatement();

            String user_id;
            user_id = ID;
            String title;
            title = in.nextLine();

            String message = "아 집가고 싶다......\n";

            File file = new File("test1.txt");
            FileWriter writer = null;

            try {
                writer = new FileWriter(file, false);
                writer.write(message);
                writer.flush();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if(writer != null) writer.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }

            String sql = "insert into n_board(user_id, title, contents )";
            sql += " VALUES(" + "'"+user_id+"', '"+title+"','"+file+"')";
            stmt.executeUpdate(sql);

            stmt.close();
            con.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }
}
