package baseball.domain.game;

import baseball.domain.hint.Hint;

import java.util.List;

public interface GameMessenger {
    String requestNumber();

    void sendHint(Hint hint);

    String requestContinueOrStop();
}
