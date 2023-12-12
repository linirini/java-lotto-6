package lotto.controller;

import static lotto.domain.winning.WinningEnum.NONE;
import static lotto.util.ExceptionEnum.NOT_NUMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Calculator;
import lotto.domain.Money;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoChecker;
import lotto.domain.lotto.LottoPublisher;
import lotto.domain.lotto.Lottos;
import lotto.domain.winning.WinningEnum;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private LottoPublisher lottoPublisher = new LottoPublisher();
    private LottoChecker lottoChecker = new LottoChecker();
    private Calculator calculator = new Calculator();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void run() {
        Money money = getMoneyInputUntilNoError();
        Lottos lottos = lottoPublisher.publishLottoByMoney(money);
        printLottos(lottos);
        Lotto lotto = getWinningNumbersUntilNoError();
        Bonus bonus = getBonusNumberUntilNoError();
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonus);
        List<WinningEnum> lottoWinnings = getLottoWinnings(lottos, winningNumbers);
        WinningResult winningResult = new WinningResult(lottoWinnings);
        String earningRate = calculator.getEarningRate(winningResult.getTotalPrize(), money);
        printResult(winningResult, earningRate);
    }

    private Money getMoneyInputUntilNoError() {
        while (true) {
            String input = inputView.inputMoney();
            try {
                return new Money(convertToInteger(input));
            } catch (Exception e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printLottos(Lottos lottos) {
        outputView.printLineBreak();
        outputView.printLottosCount(lottos);
        outputView.printLottosNumbers(lottos);
    }

    private Lotto getWinningNumbersUntilNoError() {
        while (true) {
            outputView.printLineBreak();
            String input = inputView.inputWinningLotto();
            try {
                return new Lotto(convertToNumbers(input));
            } catch (Exception e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> convertToNumbers(String input) {
        try {
            List<Integer> numbers = new ArrayList<>();
            Arrays.stream(input.split(",")).collect(Collectors.toList())
                    .forEach(number -> numbers.add(Integer.parseInt(number)));
            return numbers;
        } catch (NumberFormatException NFE) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private Bonus getBonusNumberUntilNoError() {
        while (true) {
            outputView.printLineBreak();
            String input = inputView.inputWinningBonus();
            try {
                return new Bonus(convertToInteger(input));
            } catch (Exception e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException NFE) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private List<WinningEnum> getLottoWinnings(Lottos lottos, WinningNumbers winningNumbers) {
        List<WinningEnum> lottoWinnings = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            WinningEnum result = lottoChecker.getLottoWinning(lotto, winningNumbers);
            if(result!=NONE)lottoWinnings.add(result);
        }
        return lottoWinnings;
    }

    private void printResult(WinningResult winningResult, String earningRate) {
        outputView.printLineBreak();
        outputView.printWinningStats();
        outputView.printWinningResult(winningResult);
        outputView.printEarningRates(earningRate);
    }

}
