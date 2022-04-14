package baseball.domain.game.validator;

import baseball.infrastructure.game.validator.GameValidatorImpl;
import baseball.utils.messge.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameValidatorTest {

    GameValidator gameValidator = new GameValidatorImpl();

    @Test
    @DisplayName("입력 받은 값이 3자리 수가 아니면 IllegalArgumentException 발생")
    void isThreeDigits_fail() {
        final String numbers = "1234";
        assertThatThrownBy(() -> gameValidator.isThreeDigits(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_THREE_DIGITS);
    }

    @Test
    @DisplayName("입력 받은 값이 숫자가 아니거나 0이 포함되어 있으면 IllegalArgumentException 발생")
    void isInteger_fail() {
        final String numbers = "12a";
        assertThatThrownBy(() -> gameValidator.isInteger(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_NUMBER_OR_CONTAIN_ZERO);
    }

    @Test
    @DisplayName("중복되는 숫자가 포함되어 있으면 IllegalArgumentException 발생")
    void isNotDuplicate_fail() {
        final String numbers = "122";
        assertThatThrownBy(() -> gameValidator.isNotDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CONTAIN_DUPLICATE_NUMBER);
    }

}