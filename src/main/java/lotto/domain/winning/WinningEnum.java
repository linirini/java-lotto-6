package lotto.domain.winning;

public enum WinningEnum {
    ;

    private static final String WINNING_RESULT_PREFIX = "개 일치 (";
    private static final String WINNING_RESULT_SUFFIX = "원) - ";
    private int sameNumberCount;
    private int prize;
    private int winningCount;

    WinningEnum(int sameNumberCount, int prize, int winningCount) {
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
        this.winningCount = winningCount;
    }

    public String getWinningInfo(){
        return sameNumberCount+WINNING_RESULT_PREFIX+prize+WINNING_RESULT_SUFFIX;
    }
}
