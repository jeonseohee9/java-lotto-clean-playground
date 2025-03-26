package controller;

import java.util.List;
import model.Lotto;
import model.LottoGenerator;
import model.Lottos;
import view.InputHandler;
import view.OutputHandler;
import model.WinningNumbers;
import model.LottoResult;
import model.Money;
import model.RandomLottoGenerator;

public class LottoStore {
    public static void main(String[] args) {
        Money money = InputHandler.inputMoney();
        LottoGenerator generator = new RandomLottoGenerator();
        List<Lotto> lottoList = generator.generate(money.getTicketCount());
        Lottos lottos = new Lottos(lottoList);
        OutputHandler.printPurchaseResult(lottos);

        WinningNumbers winningNumbers = InputHandler.inputWinningLotto();
        LottoResult result = new LottoResult(lottos, winningNumbers);

        OutputHandler.printStatistics(result, money);
    }
}
