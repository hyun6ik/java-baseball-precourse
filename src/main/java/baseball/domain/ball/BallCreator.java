package baseball.domain.ball;

import java.util.List;

public interface BallCreator {

    Balls createBalls(List<Integer> numberList);

}
