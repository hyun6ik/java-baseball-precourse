package baseball.domain.game;

import baseball.domain.ball.Balls;

public interface GameService {

    String requestNumber();

    void validateNumber(String numbers);

    boolean judge(Balls playerBall, Balls answerBall);

    boolean gameEndOrReStart();

}
