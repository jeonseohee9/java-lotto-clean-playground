package model;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public RankCounter countRanks(Lotto winningLotto) {
        RankCounter counter = new RankCounter();
        for (Lotto lotto : lottos) {
            counter.count(lotto, winningLotto);
        }
        return counter;
    }
}
