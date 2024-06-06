package chess;

import boardgame.Position;

public class ChessPosition {
    private final int row;
    private final char col;

    public ChessPosition(int row, char col) {
        if (col < 'a'|| col > 'h' || row < 1 || row > 8) {
            throw new ChessException("Posição no tabuleiro inválida. Posições válidas: de a1 até h8");
        }

        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public char getCol() {
        return col;
    }

    protected Position toPosition() {
        int newRow = 8 - row;
        int newCol = col - 'a';
        return new Position(newRow, newCol);
    }

    protected static ChessPosition fromPosition(Position pos) {
        int toRow = 8 - pos.getRow();
        char toCol = (char)('a' - pos.getCol());
        return new ChessPosition(toRow, toCol);
    }

    @Override
    public String toString() {
        return String.format("%c%d", col, row);
    }
}
