import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
