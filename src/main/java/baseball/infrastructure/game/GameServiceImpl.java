package baseball.infrastructure.game;

import baseball.domain.ball.Balls;
import baseball.domain.game.GameMessenger;
import baseball.domain.game.GameReferee;
import baseball.domain.game.GameService;
import baseball.domain.game.validator.GameValidator;

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
        gameValidator.validateNumber(numbers);
    }

    @Override
    public String judge(Balls balls) {
        return null;
    }

    @Override
    public void gameEndOrReStart(String answerMessage) {

    }
}
