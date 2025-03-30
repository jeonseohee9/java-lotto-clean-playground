import static java.util.Locale.LanguageRange.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import model.Lotto;
import model.LottoNumber;
import model.Lottos;
import model.Rank;
import model.RankCounter;
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
    void 등수_정확히_판별(String input, String expectedRank) {
        List<LottoNumber> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .toList();

        Lotto lotto = new Lotto(numbers);
        Lottos lottos = new Lottos(List.of(lotto));
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).toList());
        RankCounter counter = lottos.countRanks(winning);

        assertEquals(1, counter.getRankCounts().get(Rank.valueOf(expectedRank)));
    }
}
