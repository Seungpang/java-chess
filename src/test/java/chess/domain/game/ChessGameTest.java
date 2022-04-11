package chess.domain.game;

import static org.assertj.core.api.Assertions.*;

import chess.domain.board.ChessBoard;
import chess.domain.command.Command;
import chess.domain.piece.Bishop;
import chess.domain.piece.Color;
import chess.domain.piece.King;
import chess.domain.piece.Knight;
import chess.domain.piece.Piece;
import chess.domain.piece.Rook;
import chess.domain.position.ChessBoardPosition;
import chess.domain.state.Ready;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessGameTest {

    private ChessGame chessGame;

    @BeforeEach
    void setUp() {
        chessGame = new ChessGame(new Ready(ChessBoard.createChessBoard()));
        chessGame.start();
    }

    @Test
    @DisplayName("End 명령어를 입력해서 끝나는지 확인")
    void executeEndCommand() {
        chessGame.execute(Command.from("end"));

        assertThat(chessGame.isFinished()).isTrue();
    }

    @Test
    @DisplayName("Move 명령어를 입력해서 정상적으로 실행되는지 확인")
    void executeMoveCommand() {
        assertThatCode(() -> chessGame.execute(Command.from("move b2 b3")))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("잘못된 명령어 입력하면 예외 발생")
    void throwExceptionExecute() {
        assertThatThrownBy(() -> chessGame.execute(Command.from("helpMe")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("isGameEnd가 정상적으로 실행되는지 확인")
    void isGameEnd() {
        assertThat(chessGame.isGameEnd()).isFalse();
    }

    @Test
    @DisplayName("승자를 정상적으로 가져오는지 확인")
    void winner() {
        ChessGame chessGame = new ChessGame(new Ready(new ChessBoard(
            List.of(new King(Color.WHITE, ChessBoardPosition.from("a1"))))));

        chessGame.start();
        chessGame.execute(Command.from("move a1 a2"));

        assertThat(chessGame.winner()).isEqualTo(Color.WHITE);
    }

    @Test
    @DisplayName("점수를 정상적으로 가져오는지 확인")
    void score() {
        ChessGame chessGame = new ChessGame(new Ready(new ChessBoard(
            List.of(new Rook(Color.WHITE, ChessBoardPosition.from("e5")),
                new Knight(Color.WHITE, ChessBoardPosition.from("e6")),
                new Knight(Color.WHITE, ChessBoardPosition.from("e7")),
                new Bishop(Color.BLACK, ChessBoardPosition.from("a7")),
                new Bishop(Color.BLACK, ChessBoardPosition.from("a8"))))));

        chessGame.start();
        Score score = chessGame.score();

        assertThat(score.getBlackScore()).isEqualTo(6.0);
        assertThat(score.getWhiteScore()).isEqualTo(10.0);
    }
}
