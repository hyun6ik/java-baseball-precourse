package baseball.infrastructure.ball;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallCreator;
import baseball.domain.ball.Balls;

import java.util.ArrayList;
import java.util.List;

public class BallCreatorImpl implements BallCreator {

    /**
     * List 안에 있는 숫자들을 Ball 객체로 만든 다음
     * Balls 라는 일급 컬렉션에 넣는 메소드
     */
    @Override
    public Balls createBalls(List<Integer> numberList) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            ballList.add(Ball.of(numberList.get(i), i));
        }
        return Balls.of(ballList);
    }
}
