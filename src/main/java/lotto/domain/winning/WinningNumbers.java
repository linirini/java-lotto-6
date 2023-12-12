package lotto.domain.winning;

import lotto.domain.lotto.Lotto;

public class WinningNumbers {

    private final Lotto lotto;
    private final int bonus;

    public WinningNumbers(Lotto lotto, int bonus) {
        validate(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(int bonus) {
    }


}
