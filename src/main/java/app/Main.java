package app;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch match = new ChessMatch();

        while (true) {
            UI.printBoard(match.getPieces());

            System.out.println();
            System.out.print("Origem: ");
            ChessPosition source = UI.readChessPosition(sc);
            System.out.println();
            System.out.print("Destino: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece captured = match.performChessMove(source, target);
        }
    }
}