package model;

import static model.LottoConstants.MAX_MATCH;
import static model.LottoConstants.MIN_MATCH;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final List<RankResult> rankResult;

    public LottoResult(Lottos lottos, WinningNumbers winningNumbers) {
        this.rankResult = initializeRankResult();
        recordRanks(lottos, winningNumbers);
    }

    private List<RankResult> initializeRankResult() {
        List<RankResult> list = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            list.add(new RankResult(rank));
        }
        return list;
    }

    private void recordRanks(Lottos lottos, WinningNumbers winningNumbersNumber) {
        for (Lotto lotto : lottos.getLottoList()) {
            recordRankIfMath(lotto, winningNumbersNumber);
        }
    }

    private void recordRankIfMath(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = lotto.countMatchWith(winningNumbers);
        if (matchCount < MIN_MATCH || matchCount > MAX_MATCH) {
            return;
        }
        Rank rank = Rank.findByMatchCount(matchCount);
        increaseRankCount(rank);
    }

    private void increaseRankCount(Rank rank) {
        findRankResult(rank).increase();
    }

    private RankResult findRankResult(Rank rank) {
        return rankResult.stream()
                .filter(result -> result.getRank() == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Rank입니다: " + rank));
    }

    public int getTotalPrize() {
        return rankResult.stream()
                .mapToInt(RankResult::getPrizeAmount)
                .sum();
    }

    public List<RankResult> getRankResult() {
        return rankResult;
    }
}
