package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<String> getLottosNumbers(){
        List<String> lottosNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottosNumbers.add(lotto.getNumbers());
        }
        return lottosNumbers;
    }

    public int getLottosCount(){
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
