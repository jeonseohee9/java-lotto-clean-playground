package view;

import java.util.List;
import model.Lotto;
import model.LottoResult;
import model.Lottos;
import model.Money;
import model.Rank;
import model.RankResult;

public class OutputHandler {

    public static void printPurchaseResult(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(LottoResult lottoResult, Money purchaseAmount) {
        System.out.println("당첨 통계\n---------");
        List<RankResult> rankResults = lottoResult.getRankResult();

        for (RankResult rankResult : rankResults) {
            Rank rank = rankResult.getRank();
            int count = rankResult.getCount();
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원)- " + count + "개");
        }

        int totalPrize = lottoResult.getTotalPrize();
        double profitRate = purchaseAmount.calculateProfitRate(totalPrize);

        System.out.printf("총 수익률은 %.2f입니다\n", profitRate);
    }
}

