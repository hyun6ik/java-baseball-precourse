package baseball.infrastructure.game;

import baseball.domain.game.GameMessenger;
import baseball.domain.hint.Hint;
import baseball.utils.console.Console;
import baseball.utils.messge.HintMessage;
import baseball.utils.messge.Number;
import baseball.utils.messge.TextMessage;

public class GameMessengerImpl implements GameMessenger {

    @Override
    public String requestNumber() {
        printMessage(TextMessage.REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    @Override
    public void sendHint(Hint hint) {
        if (hint.getStrike() == Number.THREE) {
            printMessage(HintMessage.THREE_STRIKE);
            printMessage(HintMessage.ANSWER);
            return;
        }
        if (hint.getBall() == Number.THREE) {
            printMessage(HintMessage.THREE_BALL);
            return;
        }
        if (hint.getStrike() == Number.ZERO && hint.getBall() == Number.ZERO) {
            printMessage(HintMessage.NOTHING);
            return;
        }
        printMessage(HintMessage.StrikeAndBall(hint.getStrike(), hint.getBall()));
    }

    @Override
    public String requestContinueOrStop() {
        return null;
    }

    private void printMessage(String message) {
        System.out.print(message);
    }
}
