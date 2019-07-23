package week12;
import java.sql.*;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectionUrl = "jdbc:sqlserver://192.168.120.19:1433;" +
                    "databaseName=pratice_j;user=testj;password=12345;";
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = con.createStatement();
            System.out.println("MS-SQL 서버 접속에 성공하였습니다.");
            ResultSet rs = stmt.executeQuery("select * from a");
            while( rs.next() ) {
                String field1 = rs.getString("name_seq");
                String field2 = rs.getString("phone_number");
                System.out.print(field1 + "\t");
                System.out.println(field2);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }

}