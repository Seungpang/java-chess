package chess;

import chess.command.Command;
import chess.piece.Color;
import chess.state.Ready;
import chess.state.State;

public class ChessGame {

    private State state;

    public ChessGame() {
        this(new Ready(ChessBoard.createChessBoard()));
    }

    public ChessGame(State state) {
        this.state = state;
    }

    public void start() {
        state = state.start();
    }

    public void execute(Command command) {
        if (command.isEnd()) {
            state = state.finished();
            return;
        }
        if (command.isMove()) {
            state = state.move(command.getFrom(), command.getTo());
            return;
        }
        throw new IllegalArgumentException("명령어 입력이 잘못되었습니다.");
    }

    public boolean isFinished() {
        return state.isFinished();
    }

    public Score score() {
        return state.score();
    }

    public ChessBoard chessBoard() {
        return state.chessBoard();
    }

    public Color getWinner() {
        return state.chessBoard().getWinner();
    }
}
