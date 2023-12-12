package lotto.domain.winning;

import static lotto.util.ExceptionEnum.INVALID_NUMBER_RANGE;

import lotto.domain.lotto.Lotto;

public class WinningNumbers {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private final Lotto lotto;
    private final int bonus;

    public WinningNumbers(Lotto lotto, int bonus) {
        validate(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        throwIfInvalidBonusNumberRange(bonus);
    }

    private void throwIfInvalidBonusNumberRange(int bonus) {
        if (bonus < START_NUMBER || bonus > END_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }


}
