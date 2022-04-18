package baseball;

import baseball.config.AppConfig;
import baseball.interfaces.game.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final AppConfig appConfig = new AppConfig();
        final GameController gameController = appConfig.gameController();

        /**
         * 플레이어가 게임을 그만하고 싶을 때 까지 계속 숫자야구게임 실행
         */
        boolean isContinue;
        do {
            isContinue = gameController.baseBallGame();
        } while (isContinue);
    }
}
