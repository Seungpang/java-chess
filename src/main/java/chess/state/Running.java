package chess.state;

import chess.ChessBoard;
import chess.Score;

import chess.position.Position;

public class Running extends State {

    public Running(ChessBoard chessBoard) {
        super(chessBoard);
        chessBoard.start();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public State move(Position from, Position to) {
        chessBoard().move(from, to);
        if (chessBoard().isFinished()) {
            return new Finished(chessBoard());
        }
        return new Running(chessBoard());
    }

    @Override
    public Score score() {
        return Score.from(chessBoard());
    }

    @Override
    public State finished() {
        return new Finished(chessBoard());
    }
}
