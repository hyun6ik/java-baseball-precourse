package baseball.config;

import baseball.application.game.GameFacade;
import baseball.domain.ball.BallService;
import baseball.domain.game.GameMessenger;
import baseball.domain.game.GameProcessor;
import baseball.domain.game.GameReferee;
import baseball.domain.game.GameService;
import baseball.domain.game.validator.GameValidator;
import baseball.infrastructure.ball.BallServiceImpl;
import baseball.infrastructure.game.GameMessengerImpl;
import baseball.infrastructure.game.GameProcessorImpl;
import baseball.infrastructure.game.GameRefereeImpl;
import baseball.infrastructure.game.GameServiceImpl;
import baseball.infrastructure.game.validator.GameValidatorImpl;
import baseball.interfaces.game.GameController;


public class AppConfig {

    public GameController gameController() {
        return new GameController(gameFacade(),gameService());
    }

    public GameFacade gameFacade() {
        return new GameFacade(gameService(), ballService());
    }

    public GameService gameService() {
        return new GameServiceImpl(gameReferee(), gameMessenger(), gameValidator());
    }

    public BallService ballService() {
        return new BallServiceImpl();
    }

    public GameReferee gameReferee() {
        return new GameRefereeImpl();
    }

    public GameMessenger gameMessenger() {
        return new GameMessengerImpl();
    }

    public GameProcessor gameProcessor() {
        return new GameProcessorImpl();
    }

    public GameValidator gameValidator() {
        return new GameValidatorImpl();
    }




}
