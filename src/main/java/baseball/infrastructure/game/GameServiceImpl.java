package baseball.infrastructure.game;

import baseball.domain.ball.Balls;
import baseball.domain.game.GameMessenger;
import baseball.domain.game.GameReferee;
import baseball.domain.game.GameService;
import baseball.domain.game.validator.GameValidator;
import baseball.domain.hint.Hint;

public class GameServiceImpl implements GameService {

    private final GameReferee gameReferee;
    private final GameMessenger gameMessenger;
    private final GameValidator gameValidator;

    public GameServiceImpl(GameReferee gameReferee, GameMessenger gameMessenger, GameValidator gameValidator) {
        this.gameReferee = gameReferee;
        this.gameMessenger = gameMessenger;
        this.gameValidator = gameValidator;
    }

    /**
     * 플레이어에게 숫자를 입력해달라고 요청한 후 숫자를 입력받는 메소드
     */
    @Override
    public String requestNumber() {
        return gameMessenger.requestNumber();
    }

    /**
     * 입력받은 숫자에 문제가 없는지 검증하는 메소드
     */
    @Override
    public void validateNumber(String numbers) {
        gameValidator.isThreeDigits(numbers);
        gameValidator.isInteger(numbers);
        gameValidator.isNotDuplicate(numbers);
    }

    /**
     * 플레이어가 입력한 숫자와 정답을 비교하여
     * 플레이어에게 힌트를 준 이후
     * 정답인지 체크하는 메소드
     */
    @Override
    public boolean judge(Balls playerBall, Balls answerBall) {
        final Hint hint = gameReferee.getHint(playerBall, answerBall);
        gameMessenger.sendHint(hint);
        return gameReferee.judgeIsAnswer(hint);
    }

    /**
     * 플레이어가 정답을 맞췄다면 게임을 계속할지 그만할지 요청받고
     * 요청 값이 올바른지 검증한 후
     * 게임을 계속할지 그만할지 결정하는 메소드
     */
    @Override
    public boolean gameEndOrReStart() {
        final String responseAnswer = gameMessenger.requestContinueOrStop();
        gameValidator.validateContinueOrStop(responseAnswer);
        return gameReferee.judgeContinueOrStop(responseAnswer);
    }

}
