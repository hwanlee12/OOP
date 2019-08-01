package Board;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchAlgorithmException {
        String ID;
        Menu menu = new Menu();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://192.168.120.19:1433;" +
                    "databaseName=pratice_j;user=testj;password=12345;";
            Connection con = DriverManager.getConnection(connectionUrl);
            while(true) {
                int select = menu.menu_select();
                int after_login = 0;
                switch (select) {
                    case 1: // 로그인
                        ID = menu.login.login(con);
                        if (ID.equals("Login Error")) {
                            System.out.println("Login Error");
                            break;
                        }

                        while (true) {
                            after_login = menu.login.select_login(ID, con);
                            if (after_login == 3) {
                                break;
                            }
                        }
                        break;

                    case 2: // 회원가입
                        menu.join.join(con);
                        break;
                }
                con.close();
            }
        }
        catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }
}
