package chess.state;

import chess.ChessBoard;
import chess.position.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RunningTest {

    @Test
    @DisplayName("finished 메서드 호출 후 Finished로 변경")
    void callFinishedAfterFinishedState() {
        State running = new Running(ChessBoard.createChessBoard());

        Assertions.assertThat(running.finished()).isInstanceOf(Running.class);
    }

    @Test
    @DisplayName("기물을 움직여도 Running상태인지 확인")
    void movePieceAfterRunningState() {
        State running = new Running(ChessBoard.createChessBoard());

        Assertions.assertThat(running.move(Position.from("b2"), Position.from("b4")))
            .isInstanceOf(Running.class);
    }
}
