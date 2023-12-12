package lotto.domain;

import static lotto.util.ExceptionEnum.INVALID_MONEY_UNIT;
import static lotto.util.ExceptionEnum.MONEY_UNDER_ZERO;

public class Money {

    private static final int UNIT = 1000;
    private final int amount;


    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        throwIfAmountUnderZero(amount);
        throwIfInvalidUnit(amount);
    }

    private void throwIfAmountUnderZero(int amount) {
        if(amount<=0){
            throw new IllegalArgumentException(MONEY_UNDER_ZERO.getMessage());
        }
    }

    private void throwIfInvalidUnit(int amount) {
        if(amount%UNIT!=0){
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }

}
