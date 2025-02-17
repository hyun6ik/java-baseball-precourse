package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;
import baseball.infrastructure.game.GameRefereeImpl;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameRefereeTest {

    GameReferee gameReferee = new GameRefereeImpl();

    @Test
    @DisplayName("정답과 일치하면 3스트라이크!!")
    void getHint_threeStrike() {
        //given
        final Balls answerBall = Balls.of(Lists.newArrayList(Ball.of(1, 0), Ball.of(2, 1), Ball.of(3, 2)));
        final Balls playerBall = Balls.of(Lists.newArrayList(Ball.of(1, 0), Ball.of(2, 1), Ball.of(3, 2)));
        //when
        final Hint hint = gameReferee.getHint(playerBall, answerBall);
        //then
        assertThat(hint.getStrike()).isEqualTo(3);
        assertThat(hint.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자는 모두 맞으나 위치가 전부 틀리면 3볼!!")
    void getHint_threeBall() {
        //given
        final Balls answerBall = Balls.of(Lists.newArrayList(Ball.of(1, 0), Ball.of(2, 1), Ball.of(3, 2)));
        final Balls playerBall = Balls.of(Lists.newArrayList(Ball.of(3, 0), Ball.of(1, 1), Ball.of(2, 2)));
        //when
        final Hint hint = gameReferee.getHint(playerBall, answerBall);
        //then
        assertThat(hint.getStrike()).isEqualTo(0);
        assertThat(hint.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("1스트라이크 1볼!!")
    void getHint_oneStrikeOneBall() {
        //given
        final Balls answerBall = Balls.of(Lists.newArrayList(Ball.of(1, 0), Ball.of(2, 1), Ball.of(3, 2)));
        final Balls playerBall = Balls.of(Lists.newArrayList(Ball.of(1, 0), Ball.of(5, 1), Ball.of(2, 2)));
        //when
        final Hint hint = gameReferee.getHint(playerBall, answerBall);
        //then
        assertThat(hint.getStrike()).isEqualTo(1);
        assertThat(hint.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("3스트라이크면 true를 반환")
    void judgeIsAnswer_true() {
        //given
        final Hint hint = Hint.of(3, 0);
        //when
        final boolean isAnswer = gameReferee.judgeIsAnswer(hint);
        //then
        assertThat(isAnswer).isTrue();
    }

    @Test
    @DisplayName("3스트라이크가 아니면 false를 반환")
    void judgeIsAnswer_false() {
        //given
        final Hint hint = Hint.of(2, 1);
        //when
        final boolean isAnswer = gameReferee.judgeIsAnswer(hint);
        //then
        assertThat(isAnswer).isFalse();
    }

    @Test
    @DisplayName("플레이어가 1(Continue)를 입력하면 true를 반환")
    void judgeContinueOrStop_true() {
        //given
        final String input = "1";
        //when
        final boolean result = gameReferee.judgeContinueOrStop(input);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("플레이어가 2(Stop)를 입력하면 false를 반환")
    void judgeContinueOrStop_false() {
        //given
        final String input = "2";
        //when
        final boolean result = gameReferee.judgeContinueOrStop(input);
        //then
        assertThat(result).isFalse();
    }

}