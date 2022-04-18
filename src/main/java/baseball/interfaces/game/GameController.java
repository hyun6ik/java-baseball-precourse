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

    /**
     * 1. 1~9 사이의 숫자 3자리를 랜덤으로 생성한다.
     * 2. 플레이어에게 3자리 숫자를 입력받는다.
     * 3. 입력받은 3자리 숫자와 랜덤으로 생성한 3자리 숫자를 비교하여 정답인지 체크한다.
     * 4. 정답이라면 게임을 계속할지 말지 플레이어에게 물어본다.
     */
    public boolean baseBallGame() {
        boolean isAnswer;

        final Balls answerBall = ballService.createAnswerBalls();

        do {
            final Balls playerBall = gameFacade.requestPlayerBalls();
            isAnswer = gameService.judge(playerBall, answerBall);
        } while (!isAnswer);

        return gameService.gameEndOrReStart();
    }
}
