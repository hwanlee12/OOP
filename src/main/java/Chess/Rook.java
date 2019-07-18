package Chess;

public class Rook extends Piece{
    public Rook(int row, int col, boolean color,String type)
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
        else if((Math.abs(row - super.row) + Math.abs(col - super.col)) == 2
                || (Math.abs(row - super.row) + Math.abs(col - super.col)) == 1)
        {
            if(super.isValid(board, super.row, row, super.col, col) == true)
            {
                board.pieceset(row,col,this);
                board.pieceset(super.row, super.col, null);
                super.row = row;
                super.col = col;
                return;
            }
        }
        return;
    }
}
