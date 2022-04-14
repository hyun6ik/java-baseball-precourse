package baseball.infrastructure.ball;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallCreator;
import baseball.domain.ball.Balls;

import java.util.ArrayList;
import java.util.List;

public class BallCreatorImpl implements BallCreator {
    @Override
    public Balls createBalls(List<Integer> numberList) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            ballList.add(Ball.of(numberList.get(i), i));
        }
        return Balls.of(ballList);
    }
}
