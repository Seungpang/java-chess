package console;

import chess.ChessGame;
import chess.command.Command;
import console.view.*;

public class Application {

    public static void main(String[] args) {
        OutputView.printInitChessGameMessage();
        Command command = inputCommand();
        ChessGame chessGame = new ChessGame();

        if (command.isStart()) {
            chessGame.start();
            printBoard(chessGame);
            gamePlay(chessGame);
        }
    }

    private static void gamePlay(ChessGame chessGame) {
        while (!chessGame.isFinished()) {
            tryOneTurn(chessGame);
            printBoard(chessGame);
        }
    }

    private static void tryOneTurn(ChessGame chessGame) {
        try {
            Command command = inputCommand();
            chessGame.execute(command);
            if (command.isStatus()) {
                OutputView.printScores(chessGame.score());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            tryOneTurn(chessGame);
        }
    }

    private static void printBoard(ChessGame chessGame) {
        OutputView.printChessBoard(chessGame.chessBoard().getPieces());
        if (chessGame.chessBoard().isFinished()) {
            OutputView.printWinner(chessGame.getWinner());
        }
    }

    private static Command inputCommand() {
        try {
            return Command.from(InputView.inputCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCommand();
        }
    }
}
