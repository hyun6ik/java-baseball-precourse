package baseball.domain.ball;

import baseball.infrastructure.ball.BallFactoryImpl;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallFactoryTest {

    BallFactory ballFactory = new BallFactoryImpl();

    @Test
    @DisplayName("String으로 되어있는 숫자를 List로 변환하기")
    void numbersToIntegerList() {
        final String numbers = "123";
        final List<Integer> list = ballFactory.numbersToIntegerList(numbers);
        assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("Balls 만들기")
    void createBalls() {
        final ArrayList<Integer> list = Lists.newArrayList(1, 2, 3);
        final Balls balls = ballFactory.createBalls(list);
        assertThat(balls.getBallList().size()).isEqualTo(3);
    }
}