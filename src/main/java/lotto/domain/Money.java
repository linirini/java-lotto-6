package lotto.domain;

import static lotto.util.ExceptionEnum.INVALID_MONEY_UNIT;

public class Money {

    private static final int UNIT = 1000;
    private final int amount;


    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        throwIfInvalidUnit(amount);
    }

    private void throwIfInvalidUnit(int amount) {
        if(amount%UNIT!=0){
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
    }

}
