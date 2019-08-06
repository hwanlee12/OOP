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

            int level;
            while(true) {
                try {
                    System.out.println("권한 레벨 선택");
                    System.out.println("2 ~ 3 중에서 선택");
                    Scanner level_in = new Scanner(System.in);
                    level = level_in.nextInt();
                    if(level == 3) {
                        break;
                    }
                    else if(level == 2) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                catch(Exception e) {
                    System.out.println("다시 입력");
                    Scanner level_in = new Scanner(System.in);
                }
            }

            if(permit == 1) {
                if(level == 3) {
                    PreparedStatement pstmt_in = con.prepareStatement("insert into member(ID, Password) values(?, ?)");
                    pstmt_in.setString(1,ID);
                    pstmt_in.setString(2,md5.testMD5(Password));
                    pstmt_in.executeUpdate();

                    PreparedStatement pstmt_lv = con.prepareStatement("insert into user_lv(ID, Level) values(?, ?)");
                    pstmt_lv.setString(1,ID);
                    pstmt_lv.setInt(2, level);
                    pstmt_lv.executeUpdate();
                    System.out.println("Join success");
                }
                else if(level == 2) {
                    Scanner admin = new Scanner(System.in);
                    String admin_ID, admin_PW;
                    try {
                        System.out.println("권한1인 ID 입력");
                        System.out.print(">> ");
                        admin_ID = admin.nextLine();
                        System.out.println("권한1인 PW 입력");
                        System.out.print(">> ");
                        admin_PW = admin.nextLine();
                        admin_PW = md5.testMD5(admin_PW);

                        PreparedStatement admin_check = con.prepareStatement("select member.Password, user_lv.Level " +
                                "from member inner join user_lv on member.ID = user_lv.ID " +
                                "where member.ID = ?");
                        admin_check.setString(1, admin_ID);
                        ResultSet check_rs = admin_check.executeQuery();
                        while(check_rs.next()) {
                            String PW_rs = check_rs.getString("Password");
                            if(PW_rs.equals(admin_PW)) {
                                PreparedStatement pstmt_in = con.prepareStatement("insert into member(ID, Password) values(?, ?)");
                                pstmt_in.setString(1,ID);
                                pstmt_in.setString(2,md5.testMD5(Password));
                                pstmt_in.executeUpdate();

                                PreparedStatement pstmt_lv = con.prepareStatement("insert into user_lv(ID, Level) values(?, ?)");
                                pstmt_lv.setString(1,ID);
                                pstmt_lv.setInt(2, level);
                                pstmt_lv.executeUpdate();
                                System.out.println("Join success");
                            }
                            else {
                                System.out.println("비밀번호 일치하지 않음");
                            }
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Join error");
                    }
                }
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
