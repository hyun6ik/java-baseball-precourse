package baseball.interfaces.game;

import baseball.application.game.GameFacade;
import baseball.domain.ball.Balls;
import baseball.domain.game.GameService;

public class GameController {

    private final GameFacade gameFacade;
    private final GameService gameService;

    public GameController(GameFacade gameFacade, GameService gameService) {
        this.gameFacade = gameFacade;
        this.gameService = gameService;
    }

    public void baseBallGame() {
        final Balls balls = gameFacade.gameStart();
        final String answerMessage = gameService.judge(balls);
        gameService.gameEndOrReStart(answerMessage);
    }
}
