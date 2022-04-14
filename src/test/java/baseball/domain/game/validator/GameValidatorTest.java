package baseball.domain.game.validator;

import baseball.infrastructure.game.validator.GameValidatorImpl;
import baseball.utils.messge.ErrorMessage;
import baseball.utils.random.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameValidatorTest {

    GameValidator gameValidator = new GameValidatorImpl();

    @Test
    @DisplayName("입력 받은 값이 숫자가 아니면 IllegalArgumentException 발생")
    void validateNumber_success() {
        final String numbers = "12a";
        assertThatThrownBy(() -> gameValidator.validateNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_NUMBER);
    }
}