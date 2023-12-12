package lotto.view;

import lotto.domain.winning.WinningEnum;
import lotto.domain.winning.WinningResult;

public enum OutputEnum {

    LOTTOS_COUNT_OUTPUT("개를 구매했습니다."),
    WINNING_STATS_OUTPUT("당첨 통계\n---"),
    WINNING_RESULT_OUTPUT(""),
    EARNING_RATE_OUTPUT("");

    private static final String COUNT_UNIT_OUTPUT = "개";
    private static final String EARNING_RATE_OUTPUT_PREFIX="총 수익률은 ";
    private static final String EARNING_RATE_OUTPUT_SUFFIX="%입니다.";

    private String message;

    OutputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getLottosCountMessage(int count){
        return count + message;
    }

    public String getWinningResultMessage(String winningInfo, int count){
        return winningInfo+count+COUNT_UNIT_OUTPUT;
    }

    public String getEarningRateMessage(double rate){
        return EARNING_RATE_OUTPUT_PREFIX + rate + EARNING_RATE_OUTPUT_SUFFIX;
    }

}
