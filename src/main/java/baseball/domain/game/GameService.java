package baseball.domain.game;

import baseball.domain.ball.Balls;

public interface GameService {

    String requestNumber();

    void validateNumber(String numbers);

    String judge(Balls balls);

    void gameEndOrReStart(String answerMessage);

    Balls createAnswerBalls();
}
