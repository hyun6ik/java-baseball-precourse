package baseball.infrastructure.game.validator;

import baseball.domain.game.validator.GameValidator;
import baseball.utils.messge.ErrorMessage;

import java.util.regex.Pattern;

public class GameValidatorImpl implements GameValidator {

    private static final Pattern isNumber = Pattern.compile("^[1-9]*?");

    /**
     * 문자열이나 0이 포함되어 있으면 에러 발생
     */
    @Override
    public void isInteger(String numbers) {
        if (!isNumber.matcher(numbers).matches()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER_OR_CONTAIN_ZERO);
        }
    }

    @Override
    public void isNotDuplicate(String numbers) {

    }
}
