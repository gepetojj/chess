package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCols()];
        Position p = new Position(0, 0);

        // Para cima
        p.setValues(position.getRow() - 1, position.getCol());
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }
        // Para a esquerda
        p.setValues(position.getRow(), position.getCol() - 1);
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setCol(p.getCol() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }
        // Para a direita
        p.setValues(position.getRow(), position.getCol() + 1);
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setCol(p.getCol() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }
        // Para baixo
        p.setValues(position.getRow() + 1, position.getCol());
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        return mat;
    }
}
