package Chess;

import java.util.Random;
import java.util.Scanner;

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
        board[9][0] = new Pawn(9,0,false,"P");
        board[9][1] = new Rook(9,1,false,"R");
        board[9][2] = new Knight(9,2,false,"N");
        board[9][3] = new Bishop(9,3,false,"B");
        board[9][4] = new King(9,4,false,"K");
        board[9][5] = new Queen(9,5,false,"Q");
        board[9][6] = new Bishop(9,6,false,"B");
        board[9][7] = new Knight(9,7,false,"N");
        board[9][8] = new Rook(9,8,false,"R");
        board[9][9] = new Pawn(9,9,false,"P");
        printBoard();
        System.out.println("====================================");
    }

    // 2
    public void randgenGame() {
        Board();
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
            if(board[r][c] == null ) {
                board[r][c] = blackPawn;
                count++;
            }
        }

        count = 0;
        while(count < 2) {
            r = random.nextInt(9);
            c = random.nextInt(9);
            Rook whiteRook = new Rook(r,c,false,"R");
            if(board[r][c] == null) {
                board[r][c] = whiteRook;
                count++;
            }
        }
        count = 0;
        while(count < 2) {
            r = random.nextInt(9);
            c = random.nextInt(9);
            Rook blackRook = new Rook(r,c,true,"R");
            if(board[r][c] == null) {
                board[r][c] = blackRook;
                count++;
            }
        }

        count = 0;
        while(count < 2) {
            r = random.nextInt(9);
            c = random.nextInt(9);
            Knight whiteKnight = new Knight(r,c,false,"N");
            if(board[r][c] == null) {
                board[r][c] = whiteKnight;
                count++;
            }
        }
        count = 0;
        while(count < 2) {
            r = random.nextInt(9);
            c = random.nextInt(9);
            Knight blackKnight = new Knight(r,c,true,"N");
            if(board[r][c] == null) {
                board[r][c] = blackKnight;
                count++;
            }
        }

        count = 0;
        while(count < 2) {
            r = random.nextInt(9);
            c = random.nextInt(9);
            Bishop whiteBishop = new Bishop(r,c,false,"B");
            if(board[r][c] == null) {
                board[r][c] = whiteBishop;
                count++;
            }
        }
        count = 0;
        while(count < 2) {
            r = random.nextInt(9);
            c = random.nextInt(9);
            Bishop blackBishop = new Bishop(r,c,true,"B");
            if(board[r][c] == null) {
                board[r][c] = blackBishop;
                count++;
            }
        }

        count = 0;
        while(count < 1){
            r = random.nextInt(9);
            c = random.nextInt(9);
            Queen whiteQueen = new Queen(r,c,false,"Q");
            if(board[r][c] == null){
                board[r][c] = whiteQueen;
                count++;
            }
        }
        count = 0;
        while(count < 1){
            r = random.nextInt(9);
            c = random.nextInt(9);
            Queen blackQueen = new Queen(r,c,true,"Q");
            if(board[r][c] == null){
                board[r][c] = blackQueen;
                count++;
            }
        }

        count = 0;
        while(count < 1){
            r = random.nextInt(9);
            c = random.nextInt(9);
            King whiteKing = new King(r,c,false,"K");
            if(board[r][c] == null){
                board[r][c] = whiteKing;
                count++;
            }
        }
        count = 0;
        while(count < 1){
            r = random.nextInt(9);
            c = random.nextInt(9);
            King blackKing = new King(r,c,true,"K");
            if(board[r][c] == null){
                board[r][c] = blackKing;
                count++;
            }
        }
        printBoard();
        System.out.println("====================================");
    }

    // 3
    public void delPiece(){
        printBoard();
        System.out.println("====================================");
        Scanner in = new Scanner(System.in);
        String target;
        String sub1, sub2;
        Piece targetPiece;
        target = in.nextLine();
        sub1 = target.substring(0,1);
        sub2 = target.substring(1);

        int row = Integer.parseInt(sub2);
        row = Math.abs(row - 10);
        char temp_col[] = sub1.toCharArray();
        int col = (int)temp_col[0];
        if(col <= 74 && col >= 65)
            col = col - 65;
        else if( col >= 97 && col <= 106)
            col = col - 97;

        targetPiece = position(row, col);
        if(targetPiece != null) {
            board[row][col] = null;
        }
        else {
            System.out.println("no pieces\n");
        }
        printBoard();
        System.out.println("====================================");
    }

    // 4
    public void printBoard() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] != null) {
                    if(position(i, j).color == true) {
                        System.out.print(position(i, j).getType() + "1  ");
                    }
                    else {
                        System.out.print(position(i, j).getType() + "0  ");
                    }
                }
                else {
                    if(((i + j) % 2) == 0) {
                        System.out.print("1   ");
                    }
                    else {
                        System.out.print("0   ");
                    }
                }
            }
            System.out.println();
        }
    }

    // 5
    public void movePiece() {
        printBoard();
        System.out.println("====================================");
        Scanner in = new Scanner(System.in);
        String target;
        String sub1, sub2;
        Piece targetPiece;

        target = in.nextLine();
        sub1 = target.substring(0,1);
        sub2 = target.substring(1);
        int row = Integer.parseInt(sub2);
        row = Math.abs(row - 10);
        char temp_col[] = sub1.toCharArray();
        int col = (int)temp_col[0];
        if(col <= 74 && col >= 65)
            col = col - 65;
        else if( col >= 97 && col <= 106)
            col = col - 97;
        targetPiece = position(row, col);

        String target2;
        target2 = in.nextLine();
        sub1 = target2.substring(0,1);
        sub2 = target2.substring(1);
        row = Integer.parseInt(sub2);
        row = Math.abs(row - 10);
        char temp_col2[] = sub1.toCharArray();
        col = (int)temp_col2[0];
        if(col <= 74 && col >= 65)
            col = col - 65;
        else if( col >= 97 && col <= 106)
            col = col - 97;
        targetPiece.Moveto(row, col, this);
        printBoard();
        System.out.println("====================================");
    }

    // 행마 입력
    public int moveInputrow(String target) {
        String sub1 = target.substring(0,1);
        char temp_col[] = sub1.toCharArray();
        int col = (int)temp_col[0];
        if(col <= 74 && col >= 65)
            col = col - 65;
        else if( col >= 97 && col <= 106)
            col = col - 97;
        System.out.println(col);
        return col;
    }

    public int moveInputcol(String target) {
        String sub2 = target.substring(1);
        int row = Integer.parseInt(sub2);
        row = Math.abs(row - 10);
        System.out.println(row);
        return row;
    }
}
