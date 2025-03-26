package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static model.LottoConstants.*;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        List<Integer> allNumberList = new ArrayList<>();
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            allNumberList.add(i);
        }
        Collections.shuffle(allNumberList);
        List<Integer> selected = new ArrayList<>(allNumberList.subList(0, NUMBER_COUNT));
        Collections.sort(selected);
        return new Lotto(selected);
    }
}
