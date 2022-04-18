package baseball.domain.ball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of(List<Ball> balls) {
        return new Balls(balls);
    }

    public List<Ball> getBallList() {
        return balls;
    }

    public List<Integer> getBallNumberList() {
        List<Integer> list = new ArrayList<>();
        balls.iterator()
                .forEachRemaining(ball -> list.add(ball.getNumber()));
        return list;
    }

    public List<Integer> getBallPositionList() {
        List<Integer> list = new ArrayList<>();
        balls.iterator()
                .forEachRemaining(ball -> list.add(ball.getPosition()));
        return list;
    }

    public boolean isBall(Ball ball) {
        return this.getBallNumberList().contains(ball.getNumber());
    }

    public boolean isStrike(Ball ball) {
        return this.getBallList().get(ball.getPosition()).isStrike(ball);
    }
}
