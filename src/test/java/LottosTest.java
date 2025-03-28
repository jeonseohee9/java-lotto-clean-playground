import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import model.Lotto;
import model.Lottos;
import model.Rank;
import model.RankCounter;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void 로또_모음이_당첨과_일치하는_개수_정확히_카운트된다() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(40, 41, 42, 43, 44, 45))
        ));
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        RankCounter counter = lottos.countRanks(winning);

        assertEquals(1, counter.getRankCounts().get(Rank.SIX_MATCH));
        assertEquals(1, counter.getRankCounts().get(Rank.THREE_MATCH));
    }
}
