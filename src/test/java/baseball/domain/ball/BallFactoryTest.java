package baseball.domain.ball;

import baseball.infrastructure.ball.BallFactoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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


}