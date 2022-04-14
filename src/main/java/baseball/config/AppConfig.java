package baseball.config;

import baseball.application.game.GameFacade;
import baseball.domain.ball.BallService;
import baseball.domain.game.GameMessenger;
import baseball.domain.ball.BallFactory;
import baseball.domain.game.GameReferee;
import baseball.domain.game.GameService;
import baseball.domain.game.validator.GameValidator;
import baseball.infrastructure.ball.BallServiceImpl;
import baseball.infrastructure.game.GameMessengerImpl;
import baseball.infrastructure.ball.BallFactoryImpl;
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
        return new BallServiceImpl(ballFactory());
    }

    public GameReferee gameReferee() {
        return new GameRefereeImpl();
    }

    public GameMessenger gameMessenger() {
        return new GameMessengerImpl();
    }

    public BallFactory ballFactory() {
        return new BallFactoryImpl();
    }

    public GameValidator gameValidator() {
        return new GameValidatorImpl();
    }




}
