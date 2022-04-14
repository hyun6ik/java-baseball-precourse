package baseball.infrastructure.game;

import baseball.domain.game.GameMessenger;
import baseball.utils.console.Console;
import baseball.utils.messge.TextMessage;

public class GameMessengerImpl implements GameMessenger {

    @Override
    public String requestNumber() {
        printMessage(TextMessage.REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    private void printMessage(String message) {
        System.out.print(message);
    }
}
