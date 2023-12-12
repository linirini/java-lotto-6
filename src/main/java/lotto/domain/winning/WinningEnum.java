package lotto.domain.winning;

public enum WinningEnum {

    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 30000000),
    THIRD_PRIZE(5, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(3, 5000);

    private static final String WINNING_WITH_BONUS_RESULT_PREFIX = "개 일치, 보너스 볼 일치 (";
    private static final String WINNING_RESULT_PREFIX = "개 일치 (";
    private static final String WINNING_RESULT_SUFFIX = "원) - ";
    private int sameNumberCount;
    private int prize;

    WinningEnum(int sameNumberCount, int prize) {
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
    }

    public String getWinningInfo() {
        if (this == SECOND_PRIZE) {
            return sameNumberCount + WINNING_RESULT_PREFIX + prize + WINNING_RESULT_SUFFIX;
        }
        return sameNumberCount + WINNING_RESULT_PREFIX + prize + WINNING_RESULT_SUFFIX;
    }
}
