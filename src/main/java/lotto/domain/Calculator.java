package lotto.domain;

public class Calculator {

    public String getEarningRate(int earnedAmount, int usedAmount) {
        double rate = earnedAmount / usedAmount * 100;
        return String.format(".1f", rate);
    }

}
