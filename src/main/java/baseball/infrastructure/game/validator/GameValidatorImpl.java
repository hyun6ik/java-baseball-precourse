package baseball.infrastructure.game.validator;

import baseball.domain.game.validator.GameValidator;
import baseball.utils.messge.ErrorMessage;
import baseball.utils.messge.Number;

import java.util.HashSet;
import java.util.regex.Pattern;

public class GameValidatorImpl implements GameValidator {

    private static final Pattern isNumber = Pattern.compile("^[1-9]*?");

    /**
     * 3자리 숫자가 아니면 에러 발생
     */
    @Override
    public void isThreeDigits(String numbers) {
        if (numbers.toCharArray().length != Number.THREE) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_THREE_DIGITS);
        }
    }

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
        if (set.size() != Number.THREE) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_DUPLICATE_NUMBER);
        }
    }

    /**
     * 1(Continue) 또는 2(Stop) 말고 다른 문자를 입력했으면 에러 발생
     */
    @Override
    public void validateContinueOrStop(String responseAnswer) {
        if (!(responseAnswer.equals(Number.CONTINUE) || responseAnswer.equals(Number.STOP))) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_NUMBER);
        }
    }
}
