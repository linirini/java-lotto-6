package lotto.domain.winning;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinningResult {

    private final HashMap<WinningEnum, Integer> winnings;

    public WinningResult(List<WinningEnum> winnings) {
        this.winnings = initWinnings();
        updateWinnings(winnings);
    }

    private HashMap<WinningEnum, Integer> initWinnings() {
        HashMap<WinningEnum, Integer> winnings = new HashMap<>();
        for (WinningEnum winningEnum : WinningEnum.values()) {
            winnings.put(winningEnum, 0);
        }
        return winnings;
    }

    private void updateWinnings(List<WinningEnum> winnings) {
        for (WinningEnum winning : winnings) {
            this.winnings.put(winning, this.winnings.get(winning) + 1);
        }
    }

    public int getTotalPrize() {
        int prize = 0;
        for (Entry<WinningEnum, Integer> entry : this.winnings.entrySet()) {
            prize += entry.getKey().getPrize() * entry.getValue();
        }
        return prize;
    }

    public Map<WinningEnum, Integer> getWinnings() {
        return Collections.unmodifiableMap(winnings);
    }


}
