package chess.command;

public class EndCommand implements Command {

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isStart() {
        return false;
    }

    @Override
    public boolean isEnd() {
        return true;
    }

    @Override
    public boolean isMove() {
        return false;
    }

    @Override
    public boolean isStatus() {
        return false;
    }
}
