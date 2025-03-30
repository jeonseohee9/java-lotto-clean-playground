import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import model.Lotto;
import model.LottoNumber;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private List<LottoNumber> toLottoNumbers(Integer... numbers) {
        return List.of(numbers).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Test
    void countMatch_정확히_일치하는_숫자_개수_반환() {
        Lotto lotto1 = new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(toLottoNumbers(1, 2, 3, 7, 8, 9));

        assertEquals(3, lotto1.countMatch(lotto2));
    }

    @Test
    void 로또_번호가_6개_아니면_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(toLottoNumbers(1, 2, 3, 4, 5))); // 5개
    }

    @Test
    void 로또_번호에_중복이_있으면_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(toLottoNumbers(1, 1, 2, 3, 4, 5))); // 중복
    }

    @Test
    void 로또_번호가_1에서_45를_벗어나면_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 46))); // 46은 범위 초과
    }
}
