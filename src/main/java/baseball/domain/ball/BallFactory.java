package baseball.domain.ball;

import java.util.List;

public interface BallFactory {

    List<Integer> numbersToIntegerList(String numbers);

    List<Integer> getRandomNumbers();
}
