package baseball.domain.game;

import baseball.infrastructure.game.GameMessengerImpl;
import baseball.infrastructure.game.GameRefereeImpl;
import baseball.infrastructure.game.GameServiceImpl;
import baseball.infrastructure.game.validator.GameValidatorImpl;
import baseball.utils.messge.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    GameService gameService = new GameServiceImpl(new GameRefereeImpl(), new GameMessengerImpl(), new GameValidatorImpl());

    @Test
    @DisplayName("입력 받은 값이 3자리 수가 아니면 IllegalArgumentException 발생")
    void validateNumber_fail1() {
        //given
        final String numbers = "1234";
        //when && then
        assertThatThrownBy(() -> gameService.validateNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_THREE_DIGITS);
    }

    @Test
    @DisplayName("입력 받은 값이 숫자가 아니거나 0이 포함되어 있으면 IllegalArgumentException 발생")
    void validateNumber_fail2() {
        //given
        final String numbers = "12a";
        //when && then
        assertThatThrownBy(() -> gameService.validateNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_NUMBER_OR_CONTAIN_ZERO);
    }

    @Test
    @DisplayName("중복되는 숫자가 포함되어 있으면 IllegalArgumentException 발생")
    void validateNumber_fail3() {
        //given
        final String numbers = "122";
        //when && then
        assertThatThrownBy(() -> gameService.validateNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CONTAIN_DUPLICATE_NUMBER);
    }

}