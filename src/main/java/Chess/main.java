package Chess;
import java.util.Scanner;

public class main {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        Board board = new Board();

        while(true){
            System.out.println("1. 체스말 생성");
            System.out.println("2. 체스말 랜덤");
            System.out.println("3. 체스말 삭제");
            System.out.println("4. 체스판 보기");
            System.out.println("5. 말 이동");
            System.out.println("6. 종료");
            System.out.print(">>");
            int input = in.nextInt();

            switch (input) {
                case 1:
                    board.genGame();
                    break;

                case 2:
                    board.randgenGame();
                    break;

                case 3:
                    board.delPiece();
                    break;

                case 4:
                    board.printBoard();
                    break;

                case 5:
                    board.movePiece();
                    break;

                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
