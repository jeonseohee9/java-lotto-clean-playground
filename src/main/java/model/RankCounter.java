package model;

import java.util.EnumMap;
import java.util.Map;

public class RankCounter {

    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public RankCounter() {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void increase(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public void count(Lotto purchased, Lotto winning) {
        int matchCount = purchased.countMatchWith(winning);
        increaseByMatchCount(matchCount);
    }

    public void increaseByMatchCount(int matchCount) {
        if (!Rank.isValidMatchCount(matchCount)) {
            return;
        }
        Rank rank = Rank.findByMatchCount(matchCount);
        increase(rank);
    }


    public long getTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getRankCounts() {
        return Map.copyOf(rankCounts);
    }
}
