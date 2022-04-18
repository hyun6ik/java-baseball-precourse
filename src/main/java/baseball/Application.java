package baseball;

import baseball.config.AppConfig;
import baseball.interfaces.game.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final AppConfig appConfig = new AppConfig();
        final GameController gameController = appConfig.gameController();

        boolean isContinue;
        do {
            isContinue = gameController.baseBallGame();
        } while (isContinue);
    }
}
