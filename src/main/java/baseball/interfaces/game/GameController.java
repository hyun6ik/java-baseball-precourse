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
        final Balls answerBall = gameService.createAnswerBalls();
        final Balls playerBall = gameFacade.requestPlayerBalls();
        final String answerMessage = gameService.judge(playerBall);
        gameService.gameEndOrReStart(answerMessage);
    }
}
