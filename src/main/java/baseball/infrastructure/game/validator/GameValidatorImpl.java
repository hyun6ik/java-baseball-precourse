package baseball.infrastructure.game.validator;

import baseball.domain.game.validator.GameValidator;
import baseball.utils.messge.ErrorMessage;

public class GameValidatorImpl implements GameValidator {

    @Override
    public void validateNumber(String numbers) {
        for (char c : numbers.toCharArray()) {
            try {
                Integer.parseInt(String.valueOf(c));
            } catch (Exception e) {
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
            }
        }
    }
}
