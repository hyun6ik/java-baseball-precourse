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

    /**
     * 플레이어가 입력한 숫자를 가공하여 Balls 객체로 만드는 메소드
     */
    @Override
    public Balls createPlayerBalls(String numbers) {
        final List<Integer> numberList = ballFactory.numbersToIntegerList(numbers);
        return ballCreator.createBalls(numberList);
    }

    /**
     * 컴퓨터가 랜덤으로 생성한 숫자를 가공하여 Balls 객체로 만드는 메소드
     */
    @Override
    public Balls createAnswerBalls() {
        final List<Integer> numberList = ballFactory.getRandomNumbers();
        return ballCreator.createBalls(numberList);
    }
}
