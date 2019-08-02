package Board;

import java.sql.*;
import java.util.Scanner;

public class Join {
    public void join(Connection con) {
        String ID, Password;
        int permit = 1;
        MD5 md5 = new MD5();
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("===============Join===============");
            System.out.print("ID >> ");
            ID = in.nextLine();
            System.out.print("Password >> ");
            Password = in.nextLine();
            PreparedStatement pstmt = con.prepareStatement("select * from member where ID=?");
            pstmt.setString(1,ID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                String field_ID = rs.getString("ID");
                if(field_ID.equals(ID)) {
                    System.out.println(field_ID);
                    permit = 0;
                }
            }
            if(permit == 1) {
                PreparedStatement pstmt_in = con.prepareStatement("insert into member(ID, Password) values(?, ?)");
                pstmt_in.setString(1,ID);
                pstmt_in.setString(2,md5.testMD5(Password));
                pstmt_in.executeUpdate();
                System.out.println("Join success");
            }
            else {
                System.out.println("중복된 ID");
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }
}
