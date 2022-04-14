package baseball.infrastructure.ball;

import baseball.domain.ball.BallFactory;
import baseball.domain.ball.BallService;
import baseball.domain.ball.Balls;

import java.util.List;

public class BallServiceImpl implements BallService {

    private final BallFactory ballFactory;

    public BallServiceImpl(BallFactory ballFactory) {
        this.ballFactory = ballFactory;
    }

    @Override
    public Balls makeBalls(String numbers) {
        final List<Integer> numberList = ballFactory.numbersToIntegerList(numbers);
        return ballFactory.createBalls(numberList);
    }
}
