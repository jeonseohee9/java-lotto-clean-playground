package model;

import static model.LottoConstants.*;

public class Money {

    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("1000원 이상이어야 합니다.");
        }
    }

    public int getTicketCount() {
        return amount / PRICE_PER_LOTTO;
    }

    public double calculateProfitRate(int prize) {
        if (amount == 0) {
            return 0.0;
        }
        return (double) prize / amount;
    }
}
