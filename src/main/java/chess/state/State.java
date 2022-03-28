package chess.state;

import chess.ChessBoard;
import chess.Score;
import chess.position.Position;

public abstract class State {

    private final ChessBoard chessBoard;

    protected State(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public State start() {
        throw new IllegalStateException();
    }

    public State move(Position from, Position to) {
        throw new IllegalStateException("실행할 수 없는 명령어입니다.");
    }

    public ChessBoard chessBoard() {
        return chessBoard;
    }

    public abstract boolean isFinished();

    public abstract Score score();

    public abstract State finished();
}
