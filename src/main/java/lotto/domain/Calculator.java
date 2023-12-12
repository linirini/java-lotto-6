package lotto.domain;

public class Calculator {

    public String getEarningRate(int earnedAmount, Money usedMoney) {
        double rate = ((double)earnedAmount / usedMoney.getAmount()) * 100;
        return String.format("%.1f", rate);
    }

}
