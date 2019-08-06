package Board;

import java.util.Scanner;

public class Menu {
    Login login = new Login();
    Join join = new Join();

    public int menu_select() {
        int select = 0;
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 종료");
        System.out.print(">>");
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
        System.out.println();
        return select;
    }
}
