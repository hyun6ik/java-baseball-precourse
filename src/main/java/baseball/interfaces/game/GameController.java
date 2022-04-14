package baseball.interfaces.game;

import baseball.application.game.GameFacade;
import baseball.domain.ball.BallService;
import baseball.domain.ball.Balls;
import baseball.domain.game.GameService;

public class GameController {

    private final GameFacade gameFacade;
    private final GameService gameService;
    private final BallService ballService;

    public GameController(GameFacade gameFacade, GameService gameService, BallService ballService) {
        this.gameFacade = gameFacade;
        this.gameService = gameService;
        this.ballService = ballService;
    }

    public void baseBallGame() {
        final Balls answerBall = ballService.createAnswerBalls();
        final Balls playerBall = gameFacade.requestPlayerBalls();
        final String answerMessage = gameService.judge(playerBall, answerBall);
        gameService.gameEndOrReStart(answerMessage);
    }
}
