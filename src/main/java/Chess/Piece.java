package Chess;

public abstract class Piece {
    protected int row;
    protected int col;
    protected boolean color;
    protected String type;

    public Piece(int row, int col, boolean color, String type)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public boolean isValid(int from_r, int to_r, int from_c, int to_c)
    {
        if(from_r == to_r && from_c == to_c)
            return false;
        else if(to_r < 0 || to_r > 9 || to_c < 0 || to_c > 9)
            return false;
        else
            return true;
    }

    public abstract void Moveto(int row, int col, Board board);
}
