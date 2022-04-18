package baseball.infrastructure.game;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.game.GameReferee;
import baseball.domain.hint.Hint;
import baseball.utils.messge.Number;

public class GameRefereeImpl implements GameReferee {

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

    @Override
    public boolean judgeIsAnswer(Hint hint) {
        return hint.getStrike() == Number.THREE;
    }
}
