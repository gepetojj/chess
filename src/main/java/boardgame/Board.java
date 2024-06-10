package boardgame;

public class Board {
    private final int rows;
    private final int cols;
    private final Piece[][] pieces;

    public Board(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new BoardException("O tabuleiro precisa de ao menos 1 linha e 1 coluna.");
        }

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

    public Piece piece(int row, int col) {
        if (!positionExists(row, col)) {
            throw new BoardException("A posição solicitada não existe.");
        }

        return pieces[row][col];
    }

    public Piece piece(Position pos) {
        if (!positionExists(pos)) {
            throw new BoardException("A posição solicitada não existe.");
        }

        return pieces[pos.getRow()][pos.getCol()];
    }

    public void placePiece(Piece piece, Position pos) {
        if (isPiecePlaced(pos)) {
            throw new BoardException("Uma peça já ocupa a posição " + pos);
        }

        pieces[pos.getRow()][pos.getCol()] = piece;
        piece.position = pos;
    }

    public Piece removePiece(Position pos) {
        if (!positionExists(pos)) {
            throw new BoardException("A posição solicitada não existe.");
        }

        if (piece(pos) == null) {
            return null;
        }
        Piece aux = piece(pos);
        aux.position = null;
        pieces[pos.getRow()][pos.getCol()] = null;
        return aux;
    }

    private boolean positionExists(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean positionExists(Position pos) {
        return positionExists(pos.getRow(), pos.getCol());
    }

    public boolean isPiecePlaced(Position pos) {
        if (!positionExists(pos)) {
            throw new BoardException("A posição solicitada não existe.");
        }

        return piece(pos) != null;
    }
}
