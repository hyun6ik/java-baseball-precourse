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

    @Override
    public String requestNumber() {
        return gameMessenger.requestNumber();
    }

    @Override
    public void validateNumber(String numbers) {
        gameValidator.isThreeDigits(numbers);
        gameValidator.isInteger(numbers);
        gameValidator.isNotDuplicate(numbers);
    }

    @Override
    public boolean judge(Balls playerBall, Balls answerBall) {
        final Hint hint = gameReferee.getHint(playerBall, answerBall);
        gameMessenger.sendHint(hint);
        return gameReferee.judgeIsAnswer(hint);
    }

    @Override
    public void gameEndOrReStart(boolean isAnswer) {

    }

}
