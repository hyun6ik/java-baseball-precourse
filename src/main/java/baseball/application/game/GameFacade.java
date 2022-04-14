package baseball.application.game;

import baseball.domain.ball.BallService;
import baseball.domain.ball.Balls;
import baseball.domain.game.GameService;


public class GameFacade {

    private final GameService gameService;
    private final BallService ballService;

    public GameFacade(GameService gameService, BallService ballService) {
        this.gameService = gameService;
        this.ballService = ballService;
    }

    public Balls gameStart() {
        final String numbers = gameService.requestNumber();
        gameService.validateNumber(numbers);
        return ballService.makeBalls(numbers);
    }
}
