package view;

import java.util.List;
import java.util.Map;
import model.Lotto;
import model.Money;
import model.Rank;
import model.RankCounter;

public class OutputHandler {

    public static void printPurchaseResult(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(RankCounter counter, Money money) {
        System.out.println("당첨 통계\n---------");

        Map<Rank, Integer> rankCounts = counter.getRankCounts();
        for (Rank rank : Rank.values()) {
            int count = rankCounts.get(rank);
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원) - " + count + "개");
        }

        long totalPrize = counter.getTotalPrize();
        double profitRate = money.calculateRate(totalPrize);
        System.out.printf("총 수익률은 %.2f입니다%n", profitRate);
    }
}

