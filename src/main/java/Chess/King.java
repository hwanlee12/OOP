package Chess;

public class King extends Piece{
    public King(int row, int col, boolean color, String type) {
        super(row, col, color, type);
    }

    @Override
    public boolean Moveable(int row, int col, Board board) {
        if(board.position(row, col) != null
                && board.position(row, col).color == color
                && super.isValid(super.row, row, super.col, col) == false)
            return false;

        if(this.color == true) {
            if(col == super.col) {
                if(row > super.row) {
                    for(int i = 1; i < row - super.row; i++) {
                        if(board.position(super.row + i, super.col) != null)
                            return false;
                    }
                }
                else if(row < super.row) {
                    if(super.row - row == 1)
                        return true;
                    else
                        return false;
                }
            }
            else if(Math.abs(row - super.row) == Math.abs(col - super.col)) {
                if(row > super.row && col > super.col) {
                    for(int i = 1; i < row - super.row; i++) {
                        if(board.position(super.row + i, super.col + i) != null)
                            return false;
                    }
                }
                else if(row > super.row && col < super.col) {
                    for(int i = 1; i < row - super.row; i++) {
                        if(board.position(super.row + i, super.col - i) != null)
                            return false;
                    }
                }
                else if((Math.abs(row - super.row) + Math.abs(col - super.col) == 2)) {
                    return true;
                }
                else
                    return false;
            }
        }
        else {
            if(col == super.col) {
                if(row < super.row) {
                    for(int i = 1; i < super.row - row; i++) {
                        if(board.position(super.row - i, super.col) != null)
                            return false;
                    }
                }
                else if(row > super.row) {
                    if(row - super.row == 1)
                        return true;
                    else
                        return false;
                }
            }
            else if(Math.abs(row - super.row) == Math.abs(col - super.col)) {
                if(row < super.row && col > super.col) {
                    for(int i = 1; i < super.row - row; i++) {
                        if(board.position(super.row - i, super.col + i) != null)
                            return false;
                    }
                }
                else if(row < super.row && col < super.col) {
                    for(int i = 1; i < super.row - row; i++) {
                        if(board.position(super.row - i, super.col - i) != null)
                            return false;
                    }
                }
                else if((Math.abs(row - super.row) + Math.abs(col - super.col) == 2)) {
                    return true;
                }
                else
                    return false;
            }
        }
        return true;
    }
}
