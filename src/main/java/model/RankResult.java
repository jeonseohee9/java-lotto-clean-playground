package model;

public class RankResult {

    private final Rank rank;
    private int count;

    public RankResult(Rank rank) {
        this.rank = rank;
        this.count = 0;
    }

    public void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public int getPrizeAmount() {
        return count * rank.getPrize();
    }

    public Rank getRank() {
        return rank;
    }
}
