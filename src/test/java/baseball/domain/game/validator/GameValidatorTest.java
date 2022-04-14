package baseball.domain.game.validator;

import baseball.infrastructure.game.validator.GameValidatorImpl;
import baseball.utils.messge.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameValidatorTest {

    GameValidator gameValidator = new GameValidatorImpl();

    @Test
    @DisplayName("입력 받은 값이 숫자가 아니면 IllegalArgumentException 발생")
    void isInteger_fail() {
        final String numbers = "12a";
        assertThatThrownBy(() -> gameValidator.isInteger(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_NUMBER);
    }
}