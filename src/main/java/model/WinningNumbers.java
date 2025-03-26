package model;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;

    public WinningNumbers(List<Integer> numbers) {
        this.winningNumbers = new Lotto(numbers);
    }

    public int matchCount(Lotto purchasedLotto) {
        return (int) purchasedLotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }
}
