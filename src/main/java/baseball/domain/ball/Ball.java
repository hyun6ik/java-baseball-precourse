package baseball.domain.ball;

public class Ball {

    private int number;
    private int position;

    protected Ball() {

    }

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public static Ball of(int number, int position) {
        return new Ball(number, position);
    }

    public int getNumber() {
        return number;
    }

    public int position() {
        return position;
    }
}
