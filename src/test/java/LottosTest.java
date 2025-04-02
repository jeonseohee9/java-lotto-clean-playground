import static java.util.Locale.LanguageRange.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import model.Lotto;
import model.LottoNumber;
import model.Lottos;
import model.Rank;
import model.WinningLotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6', SIX_MATCH",
            "'1,2,3,4,5,45', FIVE_MATCH",
            "'1,2,3,4,44,45', FOUR_MATCH",
            "'1,2,3,43,44,45', THREE_MATCH"
    })
    void 등수_정확히_판별() {
        Lotto winning = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)
        ));
        LottoNumber bonus = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winning, bonus);

        Lotto matched = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)
        ));

        Lottos lottos = new Lottos(List.of(matched));
        Map<Rank, Integer> result = lottos.countResult(winningLotto);

        assertEquals(1, result.get(Rank.SIX_MATCH));
    }
}
