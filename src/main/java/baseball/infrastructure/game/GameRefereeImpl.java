package baseball.infrastructure.game;

import baseball.domain.ball.Balls;
import baseball.domain.game.GameReferee;
import baseball.domain.hint.Hint;

public class GameRefereeImpl implements GameReferee {

    @Override
    public Hint getHint(Balls playerBall, Balls answerBall) {
        return null;
    }
}
