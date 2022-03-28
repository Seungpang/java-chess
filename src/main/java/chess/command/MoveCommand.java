package chess.command;

import chess.position.Position;

public class MoveCommand implements Command {

    private final Position from;
    private final Position to;

    public MoveCommand(String command) {
        this(validateCommandLength(command));
    }

    private static String[] validateCommandLength(String command) {
        String[] split = command.split(" ");
        if (split.length != 3) {
            throw new IllegalArgumentException("move 명령어가 정상적이지 않습니다.");
        }
        return split;
    }

    public MoveCommand(String... position) {
        this(Position.from(position[1]), Position.from(position[2]));
    }

    public MoveCommand(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isStart() {
        return false;
    }

    @Override
    public Position getFrom() {
        return from;
    }

    @Override
    public Position getTo() {
        return to;
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public boolean isMove() {
        return true;
    }

    @Override
    public boolean isStatus() {
        return false;
    }
}
