package Chess;

public class Queen extends Piece{
    public Queen(int row, int col, boolean color, String type) {
        super(row, col, color, type);
    }

    @Override
    public boolean Moveable(int row, int col, Board board) {
        if(board.position(row, col) != null
                && board.position(row, col).color == color
                && super.isValid(super.row, row, super.col, col) == false)
            return false;

        if(Math.abs(super.row - row) == Math.abs(super.col - col)) {
            if(row > super.row) {
                if(col > super.col) {
                    for(int i = 1; i < row - super.row; i++) {
                        if(board.position(super.row + i, super.col + i) != null)
                            return false;
                    }
                }
                else if(col < super.col) {
                    for(int i = 1; i < row - super.row; i++) {
                        if(board.position(super.row + i, super.col - i) != null)
                            return false;
                    }
                }
            }
            else if(row < super.row) {
                if(col > super.col) {
                    for(int i = 1; i < col - super.col; i++) {
                        if(board.position(super.row - i, super.col + i) != null)
                            return false;
                    }
                }
                else if(col < super.col) {
                    for(int i = 1; i < super.col - col; i++) {
                        if(board.position(super.row - i, super.col - i) != null)
                            return false;
                    }
                }
            }
        }
        else if(row == super.row) {
            if(col > super.col) {
                for(int i = 1; i < col - super.col; i++) {
                    if(board.position(super.row, super.col + i) != null)
                        return false;
                }
            }
            else if(col < super.col) {
                for(int i = 1; i < super.col - col; i++) {
                    if(board.position(super.row, super.col - i) != null)
                        return false;
                }
            }
        }
        else if(col == super.col) {
            if(row > super.row) {
                for(int i = 1; i < row - super.row; i++) {
                    if(board.position(super.row + i, super.col) != null)
                        return false;
                }
            }
            else if(row < super.row) {
                for(int i = 1; i < super.row - row; i++) {
                    if(board.position(super.row - i, super.col) != null)
                        return false;
                }
            }
        }
        return true;
    }
}
