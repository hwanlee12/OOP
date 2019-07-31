package Board;

import java.sql.*;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;

public class Join {
    public void join()  throws ClassNotFoundException, NoSuchAlgorithmException{
        String ID, Password;
        int permit = 1;
        MD5 md5 = new MD5();
        Scanner in = new Scanner(System.in);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://192.168.120.19:1433;" +
                    "databaseName=pratice_j;user=testj;password=12345;";
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = con.createStatement();

            System.out.println("===============Join===============");
            System.out.print("ID >> ");
            ID = in.nextLine();
            System.out.print("Password >> ");
            Password = in.nextLine();

            ResultSet rs = stmt.executeQuery("select * from Board where User_ID");
            while(rs.next()) {
                String field_ID = rs.getString("User_ID");
                if(field_ID.equals(ID)) {
                    permit = 0;
                }
            }

            if(permit == 1) {
                String sql = "insert into member(ID, Password)";
                sql += " VALUES(" + "'"+ID+"', '"+md5.testMD5(Password)+"')";
                stmt.executeUpdate(sql);
                System.out.println("Join success");
            }
            else {
                System.out.println("중복된 ID");
            }

            stmt.close();
            con.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }
}
