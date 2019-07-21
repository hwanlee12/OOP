package Chess;

public class Bishop extends Piece{
    public Bishop(int row, int col, boolean color,String type) {
        super(row, col, color, type);
    }

    @Override
    public boolean Moveable(int row, int col, Board board) {
        if(board.position(row, col) != null && board.position(row, col).color == color)
            return false;

        if((Math.abs(super.row - row) + Math.abs(super.col - col)) == 1
                && super.isValid(super.row, row, super.col, col) == true) {
            return true;
        }
        else if(Math.abs(super.row - row) == Math.abs(super.col - col)
                && super.isValid(super.row, row, super.col, col) == true
                && (Math.abs(super.row - row) + Math.abs(super.col - col) == 4
                || Math.abs(super.row - row) + Math.abs(super.col - col) == 2)) {
            if(Math.abs(super.row - row) + Math.abs(super.col - col) == 4) {
                if(row > super.row) {
                    if(col > super.col) {
                        if(board.position(super.row + 1, super.col + 1) != null)
                            return false;
                        else
                            return true;
                    }
                    else if(col < super.col) {
                        if(board.position(super.row + 1, super.col - 1) != null)
                            return false;
                        else
                            return true;
                    }
                }
                else if(row < super.row) {
                    if(col > super.col) {
                        if(board.position(super.row - 1, super.col + 1) != null)
                            return false;
                        else
                            return true;
                    }
                    else if(col < super.col) {
                        if(board.position(super.row - 1, super.col - 1) != null)
                            return false;
                        else
                            return true;
                    }
                }
            }
            else
                return true;
        }
        return false;
    }
}
