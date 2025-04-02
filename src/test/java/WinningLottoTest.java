import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import model.Lotto;
import model.LottoNumber;
import model.Rank;
import model.WinningLotto;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 보너스_없을_때_정확히_일치하는_등수_반환() {
        Lotto winning = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)
        ));
        LottoNumber bonus = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winning, bonus);

        Lotto matchLotto = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)
        ));

        Rank rank = winningLotto.match(matchLotto);
        assertEquals(Rank.SIX_MATCH, rank);
    }

    @Test
    void 보너스까지_맞으면_2등() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(
                        new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)
                )),
                new LottoNumber(7)
        );

        Lotto lotto = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(7)
        ));

        assertEquals(Rank.FIVE_MATCH_BONUS, winningLotto.match(lotto));
    }
}
