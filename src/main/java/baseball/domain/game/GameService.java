package baseball.domain.game;

import baseball.domain.ball.Balls;

import java.util.List;

public interface GameService {

    List<Integer> requestNumber();

    void validateNumber(List<Integer> numbers);

    String judge(Balls balls);

    void gameEndOrReStart(String answerMessage);
}
