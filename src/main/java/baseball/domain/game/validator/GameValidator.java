package baseball.domain.game.validator;

public interface GameValidator {

    void isThreeDigits(String numbers);

    void isInteger(String numbers);

    void isNotDuplicate(String numbers);

    void validateContinueOrStop(String responseAnswer);
}
