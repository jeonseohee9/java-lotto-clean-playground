package model;

import static model.LottoConstants.*;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + NUMBER_COUNT + "개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        if (numbers.stream().anyMatch(n -> n < LOTTO_MIN || n > LOTTO_MAX)) {
            throw new IllegalArgumentException(LOTTO_MIN + " ~ " + LOTTO_MAX + " 사이의 숫자만 가능합니다.");
        }
    }

    public int countMatchWith(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
