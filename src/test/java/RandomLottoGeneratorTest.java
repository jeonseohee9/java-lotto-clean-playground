import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import model.*;
import org.junit.jupiter.api.Test;

public class RandomLottoGeneratorTest {

    @Test
    void 로또_번호는_6개_생성된다() {
        RandomLottoGenerator generator = new RandomLottoGenerator();
        List<Lotto> lottos = generator.generate(1);
        Lotto lotto = lottos.get(0);
        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    void 로또_번호는_중복되지_않는다() {
        RandomLottoGenerator generator = new RandomLottoGenerator();
        Lotto lotto = generator.generate(1).get(0);
        long distinctCount = lotto.getNumbers().stream().distinct().count();
        assertEquals(6, distinctCount);
    }

    @Test
    void 로또_번호는_범위_내에_있다() {
        RandomLottoGenerator generator = new RandomLottoGenerator();
        Lotto lotto = generator.generate(1).get(0);
        boolean allInRange = lotto.getNumbers().stream()
                .allMatch(n -> n >= 1 && n <= 45);
        assertTrue(allInRange);
    }
}
