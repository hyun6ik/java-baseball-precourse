package baseball.domain.game;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;

public interface GameReferee {

    Hint getHint(Balls playerBall, Balls answerBall);

    boolean judgeIsAnswer(Hint hint);

    boolean judgeContinueOrStop(String responseAnswer);
}
