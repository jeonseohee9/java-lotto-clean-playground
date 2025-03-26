package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.WinningNumbers;
import model.Money;
import static model.LottoConstants.*;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return new Money(amount);
    }

    public static WinningNumbers inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        List<Integer> numbers = parseNumbers(input);
        validateWinningNumbers(numbers);
        return new WinningNumbers(numbers);
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }

        if (winningNumbers.stream().distinct().count() != NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }

        if (winningNumbers.stream().anyMatch(number -> number < LOTTO_MIN || number > LOTTO_MAX)){
            throw new IllegalArgumentException("번호는 1부터 45 사이여야 합니다.");
        }
    }
}
