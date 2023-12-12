package lotto.domain.winning;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {

    private final HashMap<WinningEnum,Integer> winnings;

    public WinningResult(HashMap<WinningEnum, Integer> winnings) {
        this.winnings = winnings;
    }

    public int getPrize(){
        return -1;
    }

    public Map<WinningEnum, Integer> getWinnings() {
        return Collections.unmodifiableMap(winnings);
    }



}
