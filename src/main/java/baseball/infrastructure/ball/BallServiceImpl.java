package baseball.infrastructure.ball;

import baseball.domain.ball.BallCreator;
import baseball.domain.ball.BallFactory;
import baseball.domain.ball.BallService;
import baseball.domain.ball.Balls;

import java.util.List;

public class BallServiceImpl implements BallService {

    private final BallFactory ballFactory;
    private final BallCreator ballCreator;

    public BallServiceImpl(BallFactory ballFactory, BallCreator ballCreator) {
        this.ballFactory = ballFactory;
        this.ballCreator = ballCreator;
    }

    @Override
    public Balls createPlayerBalls(String numbers) {
        final List<Integer> numberList = ballFactory.numbersToIntegerList(numbers);
        return ballCreator.createBalls(numberList);
    }

    @Override
    public Balls createAnswerBalls() {
        return null;
    }
}
