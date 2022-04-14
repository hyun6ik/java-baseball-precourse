package baseball.infrastructure.ball;

import baseball.domain.ball.BallFactory;
import baseball.utils.messge.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallFactoryImpl implements BallFactory {

    @Override
    public List<Integer> numbersToIntegerList(String numbers) {
        final List<Integer> list = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        return list;
    }

    @Override
    public List<Integer> getRandomNumbers() {
        List<Integer> answer = new ArrayList<>();
        while(answer.size() != 3) {
            final int number = Randoms.pickNumberInRange(Number.RANDOM_MIN_VALUE, Number.RANDOM_MAX_VALUE);
            addListUntilListSizeIsThree(answer, number);
        }
        return answer;
    }

    private void addListUntilListSizeIsThree(List<Integer> answer, int number) {
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }


}
