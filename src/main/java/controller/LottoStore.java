package controller;

import model.Lotto;
import model.LottoGenerator;
import model.Lottos;
import model.RankCounter;
import view.InputHandler;
import view.OutputHandler;
import model.Money;
import model.RandomLottoGenerator;

public class LottoStore {
    public static void main(String[] args) {
        Money money = InputHandler.inputMoney();
        LottoGenerator generator = new RandomLottoGenerator();
        Lottos lottos = new Lottos(generator.generate(money.divideByThousand()));

        OutputHandler.printPurchaseResult(lottos.getLottos());

        Lotto winningLotto = InputHandler.inputWinningLotto();
        RankCounter counter = lottos.countRanks(winningLotto);

        OutputHandler.printStatistics(counter, money);
    }
}
