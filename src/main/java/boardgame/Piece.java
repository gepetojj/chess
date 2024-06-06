package boardgame;

public abstract class Piece {
    protected Position position;
    private final Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }
}
