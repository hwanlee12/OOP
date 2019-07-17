package Chess;

import java.util.Random;

public class Board {
    private Piece[][] board;

    public void Board() {
        board = new Piece[10][10];
    }

    public Piece position(int row, int col) {
        return board[row][col];
    }

    public void  pieceset(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // 1
    public void genGame() {
        Board();
        for(int i = 0; i < 10; i++) {
            board[1][i] = new Pawn(1, i,true, "P");
        }
        board[0][0] = new Pawn(0,0,true,"P");
        board[0][1] = new Rook(0,1,true,"R");
        board[0][2] = new Knight(0,2,true,"N");
        board[0][3] = new Bishop(0,3,true,"B");
        board[0][4] = new King(0,4,true,"K");
        board[0][5] = new Queen(0,5,true,"Q");
        board[0][6] = new Bishop(0,6,true,"B");
        board[0][7] = new Knight(0,7,true,"N");
        board[0][8] = new Rook(0,8,true,"R");
        board[0][9] = new Pawn(0,9,true,"P");

        for(int i = 0; i < 10; i++){
            board[8][i] = new Pawn(8,i,false, "P");
        }
        board[9][0] = new Pawn(0,0,true,"P");
        board[9][1] = new Rook(0,1,true,"R");
        board[9][2] = new Knight(0,2,true,"N");
        board[9][3] = new Bishop(0,3,true,"B");
        board[9][4] = new King(0,4,true,"K");
        board[9][5] = new Queen(0,5,true,"Q");
        board[9][6] = new Bishop(0,6,true,"B");
        board[9][7] = new Knight(0,7,true,"N");
        board[9][8] = new Rook(0,8,true,"R");
        board[9][9] = new Pawn(0,9,true,"P");
    }

    // 2
    public void randgenGame() {
        Random random = new Random();
        int r;
        int c;
        int count = 0;




        while(count < 10) {
            r = random.nextInt(9);
            c = random.nextInt(9);
            Pawn whitePawn = new Pawn(r,c,false,"P");
            if(board[r][c] == null) {
                board[r][c] = whitePawn;
                count++;
            }
        }
        count = 0;
        while(count < 10) {
            r = random.nextInt(9);
            c = random.nextInt(9);
            Pawn blackPawn = new Pawn(r,c,true,"P");
            if(board[r][c] == null) {
                board[r][c] = blackPawn;
                count++;
            }
        }
    }

    // 3


    // 4
    public void printBoard() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] != null) {
                    if(position(i, j).color == true) {
                        System.out.print(position(i, j).getType() + "1");
                    }
                    else {
                        System.out.print(position(i, j).getType() + "0");
                    }
                }
                else {
                    if(((i + j) % 2) == 0) {
                        System.out.print("1");
                    }
                    else {
                        System.out.print("0");
                    }
                }
            }
            System.out.println();
        }
    }
}
