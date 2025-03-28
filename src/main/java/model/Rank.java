package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rank {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final long prize;
    private static final Map<Integer, Rank> matchCountToRankMap = new HashMap<>();

    static {
        for (Rank rank : values()) {
            matchCountToRankMap.put(rank.matchCount, rank);
        }
    }

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
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

    public long getPrize() {
        return prize;
    }


}
