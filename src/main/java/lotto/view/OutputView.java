package lotto.view;

import static lotto.view.OutputEnum.EARNING_RATE_OUTPUT;
import static lotto.view.OutputEnum.LOTTOS_COUNT_OUTPUT;
import static lotto.view.OutputEnum.WINNING_RESULT_OUTPUT;
import static lotto.view.OutputEnum.WINNING_STATS_OUTPUT;

import java.util.Map.Entry;
import lotto.domain.lotto.Lottos;
import lotto.domain.winning.WinningEnum;
import lotto.domain.winning.WinningResult;

public class OutputView {

    public void printLottosCount(Lottos lottos) {
        int count = lottos.getLottosCount();
        System.out.println(LOTTOS_COUNT_OUTPUT.getLottosCountMessage(count));
    }

    public void printLottosNumbers(Lottos lottos) {
        for (String lottoNumbers : lottos.getLottosNumbers()) {
            System.out.println(lottoNumbers);
        }
    }

    public void printWinningStats() {
        System.out.println(WINNING_STATS_OUTPUT.getMessage());
    }

    public void printWinningResult(WinningResult winningResult) {
        for (Entry<WinningEnum, Integer> entry : winningResult.getWinnings()
                .entrySet()) {
            System.out.println(
                    WINNING_RESULT_OUTPUT.getWinningResultMessage(entry.getKey().getWinningInfo(),
                            entry.getValue()));
        }
    }

    public void printEarningRates(double rate) {
        System.out.println(EARNING_RATE_OUTPUT.getEarningRateMessage(rate));
    }

}
