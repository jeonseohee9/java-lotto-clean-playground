package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static model.LottoConstants.*;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public List<Lotto> generate(int count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(generateOne());
        }
        return result;
    }

    private Lotto generateOne() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            allNumbers.add(i);
        }
        Collections.shuffle(allNumbers);
        List<Integer> selected = new ArrayList<>(allNumbers.subList(0, NUMBER_COUNT));
        Collections.sort(selected);
        return new Lotto(selected);
    }
}
