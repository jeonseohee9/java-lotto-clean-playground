package model;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

    THREE_MATCH(3, 5000,1),
    FOUR_MATCH(4, 50000,2),
    FIVE_MATCH(5, 1500000,3),
    SIX_MATCH(6, 2000000000,4);

    private final int matchCount;
    private final long prize;
    private final int order;

    private static final Map<Integer, Rank> matchCountToRankMap = new HashMap<>();

    static {
        for (Rank rank : values()) {
            matchCountToRankMap.put(rank.matchCount, rank);
        }
    }

    Rank(int matchCount, long prize, int order) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.order = order;
    }

    public static boolean isValidMatchCount(int matchCount) {
        return matchCountToRankMap.containsKey(matchCount);
    }

    public static Rank findByMatchCount(int matchCount) {
        if (!isValidMatchCount(matchCount)) {
            throw new IllegalArgumentException("matchCount에 해당하는 Rank가 없습니다: " + matchCount);
        }
        return matchCountToRankMap.get(matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getOrder() { return order; }

    public long getPrize() {
        return prize;
    }
}
