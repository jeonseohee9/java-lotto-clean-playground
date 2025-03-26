package controller;

import view.InputHandler;
import view.OutputHandler;
import model.LottoSeller;
import model.WinningNumbers;
import model.Lottos;
import model.LottoResult;
import model.Money;
import model.RandomLottoGenerator;

public class LottoStore {
    public static void main(String[] args) {
        Money money = InputHandler.inputMoney();
        LottoSeller lottoSeller = new LottoSeller(new RandomLottoGenerator());
        Lottos lottos = lottoSeller.purchase(money);
        OutputHandler.printPurchaseResult(lottos);

        WinningNumbers winningNumbers = InputHandler.inputWinningLotto();
        LottoResult lottoResults = new LottoResult(lottos, winningNumbers);
        OutputHandler.printStatistics(lottoResults, money);
    }
}
