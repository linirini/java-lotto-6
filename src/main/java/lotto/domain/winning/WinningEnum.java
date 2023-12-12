package lotto.domain.winning;

public enum WinningEnum {
    ;

    private int sameNumberCount;
    private int prize;
    private int winningCount;

    WinningEnum(int sameNumberCount, int prize, int winningCount) {
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
        this.winningCount = winningCount;
    }
}
