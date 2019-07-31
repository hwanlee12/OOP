package Board;

import java.security.NoSuchAlgorithmException;

public class main {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchAlgorithmException {
        String ID;
        Menu menu = new Menu();

        while(true) {
            int select = menu.menu_select();
            int after_login;
            switch(select) {
                case 1: // 로그인
                    ID = menu.login.login();
                    if(ID.equals("Login Error")) {
                        System.out.println("Login Error");
                        break;
                    }
                    after_login = menu.login.select_login(ID);
                    if(after_login == 3)
                        break;

                case 2: // 회원가입
                    menu.join.join();
                    break;
            }
        }
    }
}
