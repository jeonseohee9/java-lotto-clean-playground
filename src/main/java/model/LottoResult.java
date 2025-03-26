package model;

import static model.LottoConstants.MAX_MATCH;
import static model.LottoConstants.MIN_MATCH;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final List<RankResult> rankResults = new ArrayList<>();

    public LottoResult(Lottos lottos, WinningNumbers winningNumbers) {
        for (Rank rank : Rank.values()) {
            rankResults.add(new RankResult(rank));
        }
        lottos.stream()
                .map(lotto -> lotto.countMatchWith(winningNumbers))
                .forEach(this::registerRank);
    }

    private void registerRank(int matchCount) {
        if (matchCount < MIN_MATCH || matchCount > MAX_MATCH) {
            return;
        }
        Rank rank = Rank.findByMatchCount(matchCount);
        findRankResult(rank).increase();
    }

    private RankResult findRankResult(Rank rank) {
        return rankResults.stream()
                .filter(result -> result.getRank() == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Rank입니다: " + rank));
    }

    public int getTotalPrize() {
        return rankResults.stream()
                .mapToInt(RankResult::getPrizeAmount)
                .sum();
    }

    public List<RankResult> getRankResult() {
        return rankResults;
    }
}
