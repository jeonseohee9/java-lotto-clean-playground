import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.Rank;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void 일치_숫자에_맞는_Rank_찾기() {
        assertEquals(Rank.THREE_MATCH, Rank.findByMatchCount(3));
    }

    @Test
    void 존재하지_않는_일치수는_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rank.findByMatchCount(2);
        });
    }
}
