package Chess;

public class Knight extends Piece{

    public Knight(int row, int col, boolean color, String type)
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
        else if((Math.abs(super.row - row) + Math.abs(super.col - col)) == 3)
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
        return;
    }
}
