package baseball.application.game;

import baseball.domain.ball.BallService;
import baseball.domain.ball.Balls;
import baseball.domain.game.GameService;

import java.util.List;

public class GameFacade {

    private final GameService gameService;
    private final BallService ballService;

    public GameFacade(GameService gameService, BallService ballService) {
        this.gameService = gameService;
        this.ballService = ballService;
    }

    public Balls gameStart() {
        final List<Integer> numbers = gameService.requestNumber();
        gameService.validateNumber(numbers);
        return ballService.makeBalls(numbers);
    }
}
