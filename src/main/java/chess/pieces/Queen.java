package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCols()];

        Position p = new Position(0, 0);

        // above
        p.setValues(position.getRow() - 1, position.getCol());
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getCol() - 1);
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setCol(p.getCol() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getCol() + 1);
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setCol(p.getCol() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getCol());
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        // nw
        p.setValues(position.getRow() - 1, position.getCol() - 1);
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow() - 1, p.getCol() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getCol() + 1);
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow() - 1, p.getCol() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        // se
        p.setValues(position.getRow() + 1, position.getCol() + 1);
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow() + 1, p.getCol() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getCol() - 1);
        while (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow() + 1, p.getCol() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        return mat;
    }

    @Override
    public String toString() {
        return "Q";
    }
}