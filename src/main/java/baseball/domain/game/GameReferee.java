package baseball.domain.game;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;

import java.util.List;

public interface GameReferee {

    Hint getHint(Balls playerBall, Balls answerBall);

    boolean judgeIsAnswer(Hint hint);
}
