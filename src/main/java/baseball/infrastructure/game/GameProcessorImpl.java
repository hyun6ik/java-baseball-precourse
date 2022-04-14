package baseball.infrastructure.game;

import baseball.domain.game.GameProcessor;

import java.util.ArrayList;
import java.util.List;

public class GameProcessorImpl implements GameProcessor {

    @Override
    public List<Integer> numbersToList(String numbers) {
        final List<Integer> list = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        return list;
    }
}
