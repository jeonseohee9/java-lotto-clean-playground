package model;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;

    public WinningNumbers(List<Integer> numbers) {
        this.winningNumbers = new Lotto(numbers);
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

}
