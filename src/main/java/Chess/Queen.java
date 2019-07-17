package Chess;

public class Queen extends Piece{
    public Queen(int row, int col, boolean color, String type)
    {
        super(row, col, color, type);
    }

    @Override
    public void Moveto(int row, int col)
    {
        if(board.position(row, col) != null && board.position(row, col).color == color)
            return;

        if(Math.abs(super.row - row) == Math.abs(super.col - col))
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

        for(int i = 1;i < 10; i++)
        {
            if((row == super.row + i) && (col == super.col)) {
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

        for(int i = 1;i < 10; i++)
        {
            if((row == super.row - i) && (col == super.col)) {
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

        for(int i = 1;i < 10; i++)
        {
            if((row == super.row) && (col == super.col + i)) {
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

        for(int i = 1;i < 10; i++)
        {
            if((row == super.row) && (col == super.col - i)) {
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
        return;
    }
}
