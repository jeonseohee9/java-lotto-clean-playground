package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static model.LottoConstants.*;

public class RandomLottoGenerator implements LottoGenerator {

    private static final List<Integer> ALL_NUMBERS;

    static {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            numbers.add(i);
        }
        ALL_NUMBERS = Collections.unmodifiableList(numbers);
    }

    @Override
    public List<Lotto> generate(int count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(generateOneLottoTicket());
        }
        return result;
    }

    private Lotto generateOneLottoTicket() {
        List<Integer> copy = new ArrayList<>(ALL_NUMBERS);
        Collections.shuffle(copy);
        List<LottoNumber> selected = copy.subList(0, NUMBER_COUNT).stream()
                .map(LottoNumber::new)
                .sorted((a, b) -> Integer.compare(a.getNumber(), b.getNumber()))
                .toList();
        return new Lotto(selected);
    }
}
