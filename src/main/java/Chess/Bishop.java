package Chess;

public class Bishop extends Piece{
    public Bishop(int row, int col, boolean color,String type)
    {
        super(row, col, color, type);
    }

    @Override
    public void Moveto(int row, int col, Board board)
    {
        if(board.position(row, col) != null && board.position(row, col).color == color)
        {
            System.out.println("can't move\n");
            return;
        }
        else if((Math.abs(super.row - row) + Math.abs(super.col - col)) == 1)
        {
            if(super.isValid(super.row, row, super.col, col) == true)
            {
                board.pieceset(row, col, this);
                board.pieceset(super.row, super.col, null);
                super.row = row;
                super.col = col;
                return;
            }
        }
        else if(Math.abs(super.row - row) == Math.abs(super.col - col))
        {
            if(Math.abs(super.row - row) + Math.abs(super.col - col) == 4 ||
                    Math.abs(super.row - row) + Math.abs(super.col - col) == 2)
            {
                if (super.isValid(super.row, row, super.col, col) == true) {
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
