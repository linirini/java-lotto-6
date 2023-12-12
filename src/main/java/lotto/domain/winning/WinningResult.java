package lotto.domain.winning;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WinningResult {

    private final HashMap<WinningEnum,Integer> winnings;

    public WinningResult(HashMap<WinningEnum, Integer> winnings) {
        this.winnings = initWinnings();
        updateWinnings(winnings);
    }

    private HashMap<WinningEnum, Integer> initWinnings() {
        HashMap<WinningEnum, Integer> winnings = new HashMap<>();
        for (WinningEnum winningEnum : WinningEnum.values()) {
            winnings.put(winningEnum,0);
        }
        return winnings;
    }

    private void updateWinnings(HashMap<WinningEnum, Integer> winnings) {
        for (Entry<WinningEnum, Integer> entry : winnings.entrySet()) {
            this.winnings.put(entry.getKey(),this.winnings.get(entry.getKey())+1);
        }
    }

    public int getPrize(){
        return -1;
    }

    public Map<WinningEnum, Integer> getWinnings() {
        return Collections.unmodifiableMap(winnings);
    }



}
