package baseball.domain.ball;

import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of(List<Ball> balls) {
        return new Balls(balls);
    }
}
