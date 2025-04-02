package controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Lotto;
import model.Lottos;
import model.Rank;
import model.WinningLotto;
import view.InputHandler;
import view.OutputHandler;
import model.Money;
import model.AutoLottoGenerator;

public class LottoStore {

    private final InputHandler inputHandler;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        new LottoStore(inputHandler).run();
    }

    public LottoStore(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    private void run() {
        Money money = inputHandler.inputMoney();
        int manualCount = inputHandler.inputManualCount();
        List<Lotto> manualLottos = inputHandler.inputManualLottos(manualCount);

        Lottos lottos = generateLottos(money, manualCount, manualLottos);
        printPurchaseResult(manualCount, lottos, money);

        WinningLotto winningLotto = inputHandler.inputWinningLotto();
        printStatistics(lottos, winningLotto, money);
    }

    private Lottos generateLottos(Money money, int manualCount, List<Lotto> manualLottos) {
        int autoCount = money.divideByUnit() - manualCount;
        List<Lotto> autoLottos = new AutoLottoGenerator().generate(autoCount);

        List<Lotto> allLottos = Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());

        return new Lottos(allLottos);
    }

    private void printPurchaseResult(int manualCount, Lottos lottos, Money money) {
        int autoCount = money.divideByUnit() - manualCount;
        OutputHandler.printPurchaseResult(manualCount, autoCount, lottos.getLottos());
    }

    private void printStatistics(Lottos lottos, WinningLotto winningLotto, Money money) {
        Map<Rank, Integer> result = lottos.countResult(winningLotto);
        long totalPrize = lottos.calculateTotalPrize(winningLotto);
        double rate = money.calculateRate(totalPrize);
        OutputHandler.printStatistics(result, rate);
    }
}
