package model;

import java.util.Arrays;

public enum Rank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank findByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("matchCount에 해당하는 Rank가 없습니다: " + matchCount));
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
