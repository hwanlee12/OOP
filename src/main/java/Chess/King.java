package Chess;

public class King extends Piece{
    public King(int row, int col, boolean color, String type)
    {
        super(row, col, color, type);
    }

    @Override
    public void Moveto(int row, int col)
    {
        if(board.position(row, col) != null && board.position(row, col).color == color)
        {
            System.out.println("can't move\n");
            return;
        }

        if(this.color == true)
        {
            if(row == super.row +1 && (col == super.col || col == super.col + 1 || col == super.col -1)) {
                if(super.isValid(board, super.row, row, super.col, col) == true) {
                    board.pieceset(row, col, this);
                    board.pieceset(super.row, super.col, null);
                    super.row = row;
                    super.col = col;
                    return;
                }
            }
            if(row == super.row && (col == super.col -1 || col == super.col + 1)) {
                if(super.isValid(board, super.row, row, super.col, col) == true) {
                    board.pieceset(row, col, this);
                    board.pieceset(super.row, super.col, null);
                    super.row = row;
                    super.col = col;
                    return;
                }
            }
            for(int i = 1;i < 10; ++i){
                if(row == super.row - i && col == super.col) {
                    if(super.isValid(board, super.row, row, super.col, col) == true) {
                        board.pieceset(row, col, this);
                        board.pieceset(super.row, super.col, null);
                        super.row = row;
                        super.col = col;
                        return;
                    }
                }
            }
            for(int i = 1;i < 10; ++i){
                if(row == super.row - i && col == super.col - i) {
                    if(super.isValid(board, super.row, row, super.col, col) == true) {
                        board.pieceset(row, col, this);
                        board.pieceset(super.row, super.col, null);
                        super.row = row;
                        super.col = col;
                        return;
                    }
                }
            }
            for(int i = 1;i < 10; ++i){
                if(row == super.row - i && col == super.col + i) {
                    if(super.isValid(board, super.row, row, super.col, col) == true) {
                        board.pieceset(row, col, this);
                        board.pieceset(super.row, super.col, null);
                        super.row = row;
                        super.col = col;
                        return;
                    }
                }
            }
            return;
        }
        else
        {
            if(row == super.row - 1 && (col == super.col || col == super.col + 1 || col == super.col -1)) {
                if(super.isValid(board, super.row, row, super.col, col) == true) {
                    board.pieceset(row, col, this);
                    board.pieceset(super.row, super.col, null);
                    super.row = row;
                    super.col = col;
                    return;
                }
            }
            if(row == super.row && (col == super.col -1 || col == super.col + 1)) {
                board.pieceset(row, col, this);
                board.pieceset(super.row, super.col , null);
                super.row = row;
                super.col = col;
                return;
            }
            for(int i = 1;i < 10; ++i){
                if(row == super.row + i && col == super.col) {
                    if(super.isValid(board, super.row, row, super.col, col) == true) {
                        board.pieceset(row, col, this);
                        board.pieceset(super.row, super.col, null);
                        super.row = row;
                        super.col = col;
                        return;
                    }
                }
            }
            for(int i = 1;i < 10; ++i){
                if(row == super.row + i && col == super.col - i) {
                    if(super.isValid(board, super.row, row, super.col, col) == true) {
                        board.pieceset(row, col, this);
                        board.pieceset(super.row, super.col, null);
                        super.row = row;
                        super.col = col;
                        return;
                    }
                }
            }
            for(int i = 1;i < 10; ++i){
                if(row == super.row + i && col == super.col + i) {
                    if(super.isValid(board, super.row, row, super.col, col) == true) {
                        board.pieceset(row, col, this);
                        board.pieceset(super.row, super.col, null);
                        super.row = row;
                        super.col = col;
                        return;
                    }
                }
            }
            return;
        }
    }
}
