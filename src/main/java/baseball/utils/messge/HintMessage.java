package baseball.utils.messge;

public interface HintMessage {

    String STRIKE = "스트라이크";
    String BALL = "볼";
    String NOTHING = "낫싱";

    String THREE_STRIKE = Number.THREE + STRIKE;
    String THREE_BALL = Number.THREE + BALL;

    static String StrikeAndBall(int strike, int ball) {
        return ball + BALL + " " + strike + STRIKE;
    }
}
