package model;

import static model.LottoConstants.*;

public class Money {

    private final long amount;

    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        if (amount < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(PRICE_PER_LOTTO + "원 이상이어야 합니다.");
        }
    }

    public int divideByThousand() {
        return (int) (amount / PRICE_PER_LOTTO);
    }

    public double calculateRate(long prize) {
        return (double) prize / amount;
    }
}
