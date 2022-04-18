package baseball.domain.hint;

public class Hint {

    private final int strike;
    private final int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public static Hint of(int strike, int ball) {
        return new Hint(strike, ball);
    }
}
