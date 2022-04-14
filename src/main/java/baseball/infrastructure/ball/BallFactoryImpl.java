package baseball.infrastructure.ball;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallFactory;
import baseball.domain.ball.Balls;

import java.util.ArrayList;
import java.util.List;

public class BallFactoryImpl implements BallFactory {

    @Override
    public List<Integer> numbersToIntegerList(String numbers) {
        final List<Integer> list = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        return list;
    }


}
