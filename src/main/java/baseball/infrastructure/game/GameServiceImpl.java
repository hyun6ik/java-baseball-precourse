package baseball.infrastructure.game;

import baseball.domain.ball.Balls;
import baseball.domain.game.GameReferee;
import baseball.domain.game.GameService;

import java.util.List;

public class GameServiceImpl implements GameService {

    private final GameReferee gameReferee;

    public GameServiceImpl(GameReferee gameReferee) {
        this.gameReferee = gameReferee;
    }

    @Override
    public List<Integer> requestNumber() {
        return null;
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
