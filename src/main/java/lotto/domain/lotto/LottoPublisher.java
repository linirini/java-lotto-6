package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Money;
import lotto.domain.RandomNumberGenerator;

public class LottoPublisher {

    private static final int UNIT = 1000;
    private static final RandomNumberGenerator numberGenerator = new RandomNumberGenerator();

    public Lottos publishLottoByMoney(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money.getAmount() / UNIT;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(numberGenerator.createSixRandomNumbers()));
        }
        return new Lottos(lottos);
    }

}
