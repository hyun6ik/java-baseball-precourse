package baseball.infrastructure.ball;

import baseball.domain.ball.BallFactory;
import baseball.utils.messge.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallFactoryImpl implements BallFactory {

    /**
     * String으로 되어있는 입력 받은 숫자를 Integer로 변환하여 List에 담는 메소드
     */
    @Override
    public List<Integer> numbersToIntegerList(String numbers) {
        final List<Integer> list = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        return list;
    }

    /**
     * 1~9 사이의 랜덤 숫자를 맏는 메소드
     */
    @Override
    public List<Integer> getRandomNumbers() {
        List<Integer> answer = new ArrayList<>();
        while(answer.size() != 3) {
            final int number = Randoms.pickNumberInRange(Number.RANDOM_MIN_VALUE, Number.RANDOM_MAX_VALUE);
            addListUntilListSizeIsThree(answer, number);
        }
        return answer;
    }

    /**
     * List안에 중복되지 않는 숫자만 받는 메소드
     */
    private void addListUntilListSizeIsThree(List<Integer> answer, int number) {
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }


}
