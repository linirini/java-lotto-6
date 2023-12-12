package lotto.domain.lotto;

import lotto.domain.winning.WinningEnum;
import lotto.domain.winning.WinningNumbers;

public class LottoChecker {

    public WinningEnum getLottoWinning(Lotto lotto, WinningNumbers winningNumbers) {
        int count = lotto.countSameNumbers(winningNumbers.getLotto());
        boolean hasBonus = lotto.hasNumber(winningNumbers.getBonus());
        return WinningEnum.getWinningPrize(count, hasBonus);
    }

}
