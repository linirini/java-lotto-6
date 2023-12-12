package lotto.domain;

public class Money {

    private final int amount;


    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
    }

}
