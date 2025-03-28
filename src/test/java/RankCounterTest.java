import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import model.Rank;
import model.RankCounter;
import org.junit.jupiter.api.Test;

public class RankCounterTest {

    @Test
    void increaseByMatchCount_검증() {
        RankCounter counter = new RankCounter();
        counter.increaseByMatchCount(3);
        counter.increaseByMatchCount(3);
        counter.increaseByMatchCount(4);

        Map<Rank, Integer> result = counter.getRankCounts();

        assertEquals(2, result.get(Rank.THREE_MATCH));
        assertEquals(1, result.get(Rank.FOUR_MATCH));
    }

    @Test
    void getTotalPrize_검증() {
        RankCounter counter = new RankCounter();
        counter.increaseByMatchCount(3);
        counter.increaseByMatchCount(4);
        counter.increaseByMatchCount(5);

        assertEquals(1555000, counter.getTotalPrize());
    }

    @Test
    void 유효하지_않은_매치_개수는_카운트되지_않음() {
        RankCounter counter = new RankCounter();
        counter.increaseByMatchCount(2);
        counter.increaseByMatchCount(7);

        Map<Rank, Integer> result = counter.getRankCounts();
        for (Rank rank : Rank.values()) {
            assertEquals(0, result.get(rank));
        }
    }

}
