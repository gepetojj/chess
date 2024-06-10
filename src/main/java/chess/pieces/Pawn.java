package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    private final ChessMatch match;

    public Pawn(Board board, Color color, ChessMatch match) {
        super(board, color);
        this.match = match;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCols()];
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getCol());
            if (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
                mat[p.getRow()][p.getCol()] = true;

                p.setValues(position.getRow() - 2, position.getCol());
                if (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p) && getMoveCount() == 0) {
                    mat[p.getRow()][p.getCol()] = true;
                }
            }

            p.setValues(position.getRow() - 1, position.getCol() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCol()] = true;
            }
            p.setValues(position.getRow() - 1, position.getCol() + 1);

            // En Passant Brancas
            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getCol() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == match.getEnPassantVulnerable()) {
                    mat[left.getRow() - 1][left.getCol()] = true;
                }
                Position right = new Position(position.getRow(), position.getCol() + 1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == match.getEnPassantVulnerable()) {
                    mat[right.getRow() - 1][right.getCol()] = true;
                }
            }
        } else {
            p.setValues(position.getRow() + 1, position.getCol());
            if (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p)) {
                mat[p.getRow()][p.getCol()] = true;

                p.setValues(position.getRow() + 2, position.getCol());
                if (getBoard().positionExists(p) && !getBoard().isPiecePlaced(p) && getMoveCount() == 0) {
                    mat[p.getRow()][p.getCol()] = true;
                }
            }

            p.setValues(position.getRow() + 1, position.getCol() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCol()] = true;
            }
            p.setValues(position.getRow() + 1, position.getCol() + 1);

            // En Passant Pretas
            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getCol() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == match.getEnPassantVulnerable()) {
                    mat[left.getRow() + 1][left.getCol()] = true;
                }
                Position right = new Position(position.getRow(), position.getCol() + 1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == match.getEnPassantVulnerable()) {
                    mat[right.getRow() + 1][right.getCol()] = true;
                }
            }
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
