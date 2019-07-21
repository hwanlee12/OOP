package Chess;

public class Rook extends Piece{
    public Rook(int row, int col, boolean color,String type) {
        super(row, col, color, type);
    }

    @Override
    public boolean Moveable(int row, int col, Board board) {
        if(board.position(row, col) != null && board.position(row, col).color == color)
            return false;

        if(((Math.abs(row - super.row) + Math.abs(col - super.col)) == 2
                || (Math.abs(row - super.row) + Math.abs(col - super.col)) == 1)
                && super.isValid(super.row, row, super.col, col) == true) {
            if((Math.abs(row - super.row) + Math.abs(col - super.col)) == 2 && (super.row == row)) {
                if(col > super.col) {
                    if(board.position(super.col + 1, super.row) != null)
                        return false;
                    else
                        return true;
                }
                else if(col < super.col) {
                    if(board.position(super.col - 1, super.row) != null)
                        return false;
                    else
                        return true;
                }
            }
            else if((Math.abs(row - super.row) + Math.abs(col - super.col)) == 2 && (super.col == col)) {
                if(row > super.row) {
                    if(board.position(super.col, super.row + 1) != null)
                        return false;
                    else
                        return true;
                }
                else if(row < super.row) {
                    if(board.position(super.col, super.row - 1) != null)
                        return false;
                    else
                        return true;
                }
            }
            else {
                return true;
            }
        }
        return false;
    }
}
