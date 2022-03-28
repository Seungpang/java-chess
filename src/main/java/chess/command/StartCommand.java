package chess.command;

public class StartCommand implements Command {

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isStart() {
        return true;
    }

    @Override
    public boolean isEnd() {
        return false;
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
