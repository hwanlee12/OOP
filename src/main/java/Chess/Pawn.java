package Chess;

public class Pawn extends Piece {
    public Pawn(int row, int col, boolean color, String type)
    {
        super(row, col, color, type);
    }

    @Override
    public void Moveto(int row, int col) {
        if(board.position(row, col) != null && board.position(row, col).color == color)
            return;
        else if((row == super.row + 1 || row == super.row - 1 ) && col == super.col)
        {
            if(super.isValid(board, super.row, row, super.col, col) == true)
            {
                board.pieceset(row, col, this);
                board.pieceset(super.row, super.col, null);
                super.row = row;
                super.col = col;
                return;
            }
        }
    }
}
