package chess.state;

import chess.ChessBoard;
import chess.Score;

public class Finished extends State {

    public Finished(ChessBoard chessBoard) {
        super(chessBoard);
    }

    public boolean isFinished() {
        return true;
    }

    @Override
    public State finished() {
        throw new IllegalStateException();
    }

    @Override
    public Score score() {
        return Score.from(chessBoard());
    }
}
