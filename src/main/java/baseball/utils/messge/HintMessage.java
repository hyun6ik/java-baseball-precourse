package baseball.utils.messge;

public interface HintMessage {

    String STRIKE = "스트라이크";
    String BALL = "볼";
    String ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    String NOTHING = "낫싱";

    String THREE_STRIKE = Number.THREE + STRIKE;
    String THREE_BALL = Number.THREE + BALL;

    static String StrikeAndBall(int strike, int ball) {
        return strike + STRIKE + " " + ball + BALL;
    }
}
