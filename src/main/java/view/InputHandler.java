package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Lotto;
import model.LottoNumber;
import model.Money;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        String input = readLineMessage("구입금액을 입력해 주세요.");
        return parseMoney(input);
    }

    public static Lotto inputWinningLotto() {
        String input = readLineMessage("지난주 당첨 번호를 입력해 주세요.");
        return parseWinningLotto(input);
    }

    private static String readLineMessage(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private static Money parseMoney(String input) {
        try {
            return new Money(Long.parseLong(input.trim()));
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private static Lotto parseWinningLotto(String input) {
        try {
            List<LottoNumber> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해야 합니다.");
            return inputWinningLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLotto();
        }
    }
}
