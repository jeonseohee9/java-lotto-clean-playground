package model;

import java.util.Arrays;

public enum Rank {

    THREE_MATCH(3,false, 5000,1),
    FOUR_MATCH(4,false, 50000,2),
    FIVE_MATCH(5,false, 1500000,3),
    FIVE_MATCH_BONUS(5, true, 30000000, 4),
    SIX_MATCH(6,false, 2000000000,5),
    NONE(0, false, 0, 0);

    private final int matchCount;
    private final long prize;
    private final int order;
    private final boolean matchBonus;


    Rank(int matchCount, boolean matchBonus, long prize, int order) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.order = order;
    }

    public static Rank determine(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == bonusMatch)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public int getOrder() {
        return order;
    }
}
