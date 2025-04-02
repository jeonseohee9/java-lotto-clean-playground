package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Lotto;
import model.LottoNumber;
import model.Money;
import model.WinningLotto;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return new Money(Long.parseLong(scanner.nextLine().trim()));
        } catch (Exception e) {
            System.out.println("올바른 금액을 입력해주세요.");
            return inputMoney();
        }
    }

    public int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public List<Lotto> inputManualLottos(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < count) {
            lottos.add(readValidLotto());
        }

        return lottos;
    }

    private Lotto readValidLotto() {
        String line = scanner.nextLine();
        try {
            List<LottoNumber> numbers = Arrays.stream(line.split(","))
                    .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                    .collect(Collectors.toList());

            return new Lotto(numbers);
        } catch (Exception e) {
            System.out.println("올바른 형식으로 다시 입력해주세요.");
            return readValidLotto();
        }
    }

    public WinningLotto inputWinningLotto() {
        System.out.println("지난주 당첨 번호를 입력해 주세요.");

        List<LottoNumber> numbers = Arrays.stream(scanner.nextLine().split(","))
                .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                .collect(Collectors.toList());

        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNumber bonus = new LottoNumber(Integer.parseInt(scanner.nextLine().trim()));

        return new WinningLotto(new Lotto(numbers), bonus);
    }
}
