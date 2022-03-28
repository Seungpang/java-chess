package chess.command;

import chess.position.Position;

public interface Command {

    static Command from(String command) {
        if (command.equals("start")) {
            return new StartCommand();
        }
        if (command.equals("end")) {
            return new EndCommand();
        }
        if (command.equals("status")) {
            return new StatusCommand();
        }
        if (command.startsWith("move")) {
            return new MoveCommand(command);
        }
        throw new IllegalArgumentException();
    }

    boolean isFinished();

    boolean isStart();

    default Position getFrom() {
        return null;
    }

    default Position getTo() {
        return null;
    }

    boolean isEnd();

    boolean isMove();

    boolean isStatus();
}
