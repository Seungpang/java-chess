package chess.domain.piece;

import chess.domain.position.Position;
import java.util.Collection;

public class Queen extends Piece {

    private static final int QUEEN_SCORE = 9;

    public Queen(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Piece createNewPiece(Position to) {
        return new Queen(getColor(), to);
    }

    @Override
    protected boolean isPossibleMovement(Position to, Collection<Piece> pieces) {
        return getPosition().isDiagonalWay(to) || getPosition().isVerticalWay(to)
            || getPosition().isHorizontalWay(to);
    }

    @Override
    public double score() {
        return QUEEN_SCORE;
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public boolean isKing() {
        return false;
    }
}
