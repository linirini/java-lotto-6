package lotto.domain.lotto;

import static lotto.util.ExceptionEnum.INVALID_NUMBER_RANGE;

public class Bonus {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonus) {
        throwIfInvalidBonusNumberRange(bonus);
    }

    private void throwIfInvalidBonusNumberRange(int bonus) {
        if (bonus < START_NUMBER || bonus > END_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
