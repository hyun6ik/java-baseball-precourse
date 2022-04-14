package baseball.infrastructure.game.validator;

import baseball.domain.game.validator.GameValidator;
import baseball.utils.messge.ErrorMessage;
import baseball.utils.messge.Number;

import java.util.HashSet;
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

    /**
     * 중복되는 숫자가 있으면 에러 발생
     */
    @Override
    public void isNotDuplicate(String numbers) {
        final HashSet<Character> set = new HashSet<>();
        for (char aChar : numbers.toCharArray()) {
            set.add(aChar);
        }
        if (set.size() != Number.INPUT_MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_DUPLICATE_NUMBER);
        }
    }
}
