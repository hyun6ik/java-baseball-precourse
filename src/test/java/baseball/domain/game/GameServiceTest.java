package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;
import baseball.infrastructure.game.GameMessengerImpl;
import baseball.infrastructure.game.GameRefereeImpl;
import baseball.infrastructure.game.GameServiceImpl;
import baseball.infrastructure.game.validator.GameValidatorImpl;
import baseball.utils.messge.ErrorMessage;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("3스트라이크면 true를 반환")
    void judge_true() {
        //given
        final Balls answerBall = Balls.of(Lists.newArrayList(Ball.of(1, 0), Ball.of(2, 1), Ball.of(3, 2)));
        final Balls playerBall = Balls.of(Lists.newArrayList(Ball.of(1, 0), Ball.of(2, 1), Ball.of(3, 2)));
        //when
        final boolean isAnswer = gameService.judge(playerBall,answerBall);
        //then
        assertThat(isAnswer).isTrue();
    }

    @Test
    @DisplayName("3스트라이크가 아니면 false를 반환")
    void judge_false() {
        //given
        final Balls answerBall = Balls.of(Lists.newArrayList(Ball.of(1, 0), Ball.of(2, 1), Ball.of(3, 2)));
        final Balls playerBall = Balls.of(Lists.newArrayList(Ball.of(3, 0), Ball.of(1, 1), Ball.of(2, 2)));
        //when
        final boolean isAnswer = gameService.judge(playerBall, answerBall);
        //then
        assertThat(isAnswer).isFalse();
    }

}