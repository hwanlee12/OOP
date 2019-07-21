package Chess;

public class Knight extends Piece{

    public Knight(int row, int col, boolean color, String type) {
        super(row, col, color, type);
    }

    @Override
    public boolean Moveable(int row, int col, Board board) {
        if(board.position(row, col) != null && board.position(row, col).color == color)
            return false;
        if((Math.abs(super.row - row) + Math.abs(super.col - col)) == 3) {
            if(super.isValid(super.row, row, super.col, col) == true) {
                return true;
            }
        }
        return false;
    }
}
