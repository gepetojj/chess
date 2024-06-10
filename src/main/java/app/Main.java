package app;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch match = new ChessMatch();
        List<ChessPiece> capturedPieces = new ArrayList<>();

        while (match.getNotCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(match, capturedPieces);

                System.out.println();
                System.out.print("Origem: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = match.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(match.getPieces(), possibleMoves);

                System.out.print("Destino: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece captured = match.performChessMove(source, target);
                if (captured != null) {
                    capturedPieces.add(captured);
                }

                if (match.getPromoted() != null) {
                    System.out.print("Escolha uma peça para promoção (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                        System.out.print("Valor inválido! Escolha uma peça para promoção (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    match.replacePromotedPiece(type);
                }
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(match, capturedPieces);
    }
}