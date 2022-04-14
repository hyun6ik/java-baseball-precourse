package baseball.config;

import baseball.application.game.GameFacade;
import baseball.domain.ball.BallService;
import baseball.domain.game.GameReferee;
import baseball.domain.game.GameService;
import baseball.infrastructure.ball.BallServiceImpl;
import baseball.infrastructure.game.GameRefereeImpl;
import baseball.infrastructure.game.GameServiceImpl;
import baseball.interfaces.game.GameController;


public class AppConfig {

    public GameController gameController() {
        return new GameController(gameFacade(),gameService());
    }

    public GameFacade gameFacade() {
        return new GameFacade(gameService(), ballService());
    }

    public GameService gameService() {
        return new GameServiceImpl(gameQuestioner());
    }

    public BallService ballService() {
        return new BallServiceImpl();
    }

    public GameReferee gameQuestioner() {
        return new GameRefereeImpl();
    }


}
