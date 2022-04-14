package baseball.domain.game.validator;

public interface GameValidator {

    void isInteger(String numbers);

    void isNotDuplicate(String numbers);
}
