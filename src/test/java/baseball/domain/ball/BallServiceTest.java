package baseball.domain.ball;

import baseball.infrastructure.ball.BallCreatorImpl;
import baseball.infrastructure.ball.BallFactoryImpl;
import baseball.infrastructure.ball.BallServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallServiceTest {

    BallService ballService = new BallServiceImpl(new BallFactoryImpl(), new BallCreatorImpl());


    @Test
    void createPlayerBalls() {
        //given
        final String numbers = "456";
        //when
        final Balls playerBalls = ballService.createPlayerBalls(numbers);
        //then
        assertThat(playerBalls.getBallNumberList()).containsExactly(4, 5, 6);
        assertThat(playerBalls.getBallPositionList()).containsExactly(0, 1, 2);
    }

    @Test
    void createAnswerBalls() {
        //given && when
        final Balls answerBalls = ballService.createAnswerBalls();
        //then
        assertThat(answerBalls.getBallList().size()).isEqualTo(3);
        assertThat(answerBalls.getBallNumberList().size()).isEqualTo(3);
        assertThat(answerBalls.getBallPositionList().size()).isEqualTo(3);
    }
}