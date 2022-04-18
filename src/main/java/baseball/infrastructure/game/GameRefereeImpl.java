package baseball.infrastructure.game;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.game.GameReferee;
import baseball.domain.hint.Hint;
import baseball.utils.messge.Number;

public class GameRefereeImpl implements GameReferee {

    /**
     * 플레이어가 입력한 숫자와 정답(숫자)를 비교하여
     * 스트라이크가 몇 개이고 볼이 몇 개인지
     * 힌트를 생성하는 메소드
     */
    @Override
    public Hint getHint(Balls playerBall, Balls answerBall) {
        int strike = 0;
        int ball = 0;

        for (Ball b : playerBall.getBallList()) {
            if (answerBall.isBall(b)) {
                ball++;
            }
            if (answerBall.isStrike(b)) {
                ball--;
                strike++;
            }
        }
        return Hint.of(strike, ball);
    }

    /**
     * 플레이어가 입력한 숫자가 정답인지 체크하는 메소드
     */
    @Override
    public boolean judgeIsAnswer(Hint hint) {
        return hint.getStrike() == Number.THREE;
    }

    /**
     * 플레이어가 게임을 계속할지 그만할지 판단하는 메소드
     */
    @Override
    public boolean judgeContinueOrStop(String responseAnswer) {
        return responseAnswer.equals(Number.CONTINUE);
    }
}
