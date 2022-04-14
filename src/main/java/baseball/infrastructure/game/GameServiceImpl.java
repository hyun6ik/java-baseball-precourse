package baseball.infrastructure.game;

import baseball.domain.ball.Balls;
import baseball.domain.game.GameMessenger;
import baseball.domain.game.GameReferee;
import baseball.domain.game.GameService;

import java.util.List;

public class GameServiceImpl implements GameService {

    private final GameReferee gameReferee;
    private final GameMessenger gameMessenger;

    public GameServiceImpl(GameReferee gameReferee, GameMessenger gameMessenger) {
        this.gameReferee = gameReferee;
        this.gameMessenger = gameMessenger;
    }

    @Override
    public List<Integer> requestNumber() {
        return gameMessenger.requestNumber();
    }

    @Override
    public void validateNumber(List<Integer> numbers) {

    }

    @Override
    public String judge(Balls balls) {
        return null;
    }

    @Override
    public void gameEndOrReStart(String answerMessage) {

    }
}
