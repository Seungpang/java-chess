package chess.state;

import chess.ChessBoard;
import chess.Score;

public class Ready extends State {

    public Ready(ChessBoard chessBoard) {
        super(chessBoard);
    }

    @Override
    public State start() {
        return new Running(chessBoard());
    }

    public State finished() {
        return new Finished(chessBoard());
    }

    public boolean isFinished() {
        return false;
    }

    @Override
    public Score score() {
        throw new IllegalStateException("실행할 수 없는 명령어입니다.");
    }
}
