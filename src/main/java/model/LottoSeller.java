package model;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private final RandomLottoGenerator generator;

    public LottoSeller(RandomLottoGenerator generator) {
        this.generator = generator;
    }

    public Lottos purchase(Money money) {
        int count = money.getTicketCount();
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(generator.generate());
        }
        return new Lottos(lottoList);
    }

}
