package Board;

import java.security.NoSuchAlgorithmException;

public class main {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchAlgorithmException {
        String ID;
        Menu menu = new Menu();

        while(true) {
            int select = menu.menu_select();
            int after_login = 0;
            switch(select) {
                case 1: // 로그인
                    ID = menu.login.login();
                    if(ID.equals("Login Error")) {
                        System.out.println("Login Error");
                        break;
                    }

                    while(true) {
                        after_login = menu.login.select_login(ID);
                        if(after_login == 3)
                        {
                            System.out.println("dlksfdlsfdlf");
                            break;
                        }
                    }

                case 2: // 회원가입
                    menu.join.join();
                    break;
            }
        }
    }
}
