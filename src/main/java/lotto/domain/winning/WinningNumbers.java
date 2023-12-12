package lotto.domain.winning;

import static lotto.util.ExceptionEnum.INVALID_NUMBER_RANGE;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;

public class WinningNumbers {

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningNumbers(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus.getBonusNumber();
    }

}
