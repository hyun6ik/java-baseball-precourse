package baseball.infrastructure.game;

import baseball.domain.game.GameMessenger;
import baseball.domain.hint.Hint;
import baseball.utils.console.Console;
import baseball.utils.messge.HintMessage;
import baseball.utils.messge.Number;
import baseball.utils.messge.TextMessage;

public class GameMessengerImpl implements GameMessenger {

    /**
     * 플레이어에게 숫자를 입력해달라고 요청한다음
     * 숫자(String)를 입력 받아오는 메소드
     */
    @Override
    public String requestNumber() {
        printNotLineBreakMessage(TextMessage.REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    /**
     * 플레이어가 입력한 숫자를 토대로
     * 힌트를 출력하는 메소드
     */
    @Override
    public void sendHint(Hint hint) {
        if (hint.getStrike() == Number.THREE) {
            printMessage(HintMessage.THREE_STRIKE);
            printMessage(TextMessage.ANSWER);
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

    /**
     * 플레이어에게 게임을 계속할지 종료할지 요청한 다음
     * 1 또는 2의 값을 받아오는 메소드
    */
    @Override
    public String requestContinueOrStop() {
        printMessage(TextMessage.CONTINUE_OR_END);
        return Console.readLine();
    }

    /**
     * 줄바꿈이 있는 메시지를 출력하는 메소드
     */
    private void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * 줄바꿈이 없는 메시지를 출력하는 메소드
     */
    private void printNotLineBreakMessage(String message) {
        System.out.print(message);
    }

}
