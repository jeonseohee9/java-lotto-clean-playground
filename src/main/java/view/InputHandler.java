package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Lotto;
import model.Money;

import static model.LottoConstants.*;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                long amount = Long.parseLong(scanner.nextLine().trim());
                return new Money(amount);
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningLotto() {
        while (true) {
            try {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                String input = scanner.nextLine();
                List<Integer> numbers = parseNumbers(input);
                return new Lotto(numbers);
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }
}
