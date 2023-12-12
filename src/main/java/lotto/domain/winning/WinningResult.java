package lotto.domain.winning;

import java.util.HashMap;

public class WinningResult {

    private final HashMap<WinningEnum,Integer> winnings;

    public WinningResult(HashMap<WinningEnum, Integer> winnings) {
        this.winnings = winnings;
    }

    public int getPrize(){
        return -1;
    }


}
