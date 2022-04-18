package baseball.domain.ball;

import baseball.infrastructure.ball.BallCreatorImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCreatorTest {

    BallCreator ballCreator = new BallCreatorImpl();

    @Test
    @DisplayName("Balls 만들기")
    void createBalls() {
        //given
        final ArrayList<Integer> list = Lists.newArrayList(1, 2, 3);
        //when
        final Balls balls = ballCreator.createBalls(list);
        //then
        assertThat(balls.getBallList().size()).isEqualTo(3);
    }
}
