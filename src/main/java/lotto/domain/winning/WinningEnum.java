package lotto.domain.winning;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public enum WinningEnum {

    NONE(0, 0),
    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 30000000),
    THIRD_PRIZE(5, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(3, 5000);

    private static final String WINNING_WITH_BONUS_RESULT_PREFIX = "개 일치, 보너스 볼 일치 (";
    private static final String WINNING_RESULT_PREFIX = "개 일치 (";
    private static final String WINNING_RESULT_SUFFIX = "원) - ";
    private final int sameNumberCount;
    private final int prize;

    WinningEnum(int sameNumberCount, int prize) {
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
    }

    private int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getWinningInfo() {
        if (this == SECOND_PRIZE) {
            return sameNumberCount + WINNING_WITH_BONUS_RESULT_PREFIX + formatPrize(prize)
                    + WINNING_RESULT_SUFFIX;
        }
        return sameNumberCount + WINNING_RESULT_PREFIX + formatPrize(prize) + WINNING_RESULT_SUFFIX;
    }

    private String formatPrize(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(prize);
    }

    public static WinningEnum getWinningPrize(int count, boolean hasBonus) {
        if (count == 5) {
            if (hasBonus) {
                return SECOND_PRIZE;
            }
            return THIRD_PRIZE;
        }
        return Arrays.stream(values())
                .filter(winningEnum -> winningEnum.sameNumberCount == count).findAny().orElse(NONE);
    }

    private static final Comparator<WinningEnum> COMPARATOR = Comparator
            .comparingInt(WinningEnum::getSameNumberCount)
            .thenComparingInt(WinningEnum::getPrize);

    public static WinningEnum[] sortedValues() {
        WinningEnum[] values = values();
        Arrays.sort(values, COMPARATOR);
        return values;
    }

}
