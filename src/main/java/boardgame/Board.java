package boardgame;

public class Board {
    private final int rows;
    private final int cols;
    private Piece[][] pieces;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        pieces = new Piece[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}