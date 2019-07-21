package Chess;

public class Pawn extends Piece {
    public Pawn(int row, int col, boolean color, String type) {
        super(row, col, color, type);
    }

    @Override
    public boolean Moveable(int row, int col, Board board) {
        if(board.position(row, col) != null && board.position(row, col).color == color)
            return false;
        if((row == super.row + 1 || row == super.row - 1 ) && col == super.col) {
            if(super.isValid(super.row, row, super.col, col) == true) {
                return true;
            }
        }
        return false;
    }
}
