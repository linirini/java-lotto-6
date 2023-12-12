package lotto.domain.lotto;

import static lotto.domain.winning.WinningEnum.NONE;
import static lotto.domain.winning.WinningEnum.SECOND_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    private LottoChecker lottoChecker;

    @BeforeEach
    void init() {
        lottoChecker = new LottoChecker();
    }

    @DisplayName("로또 당첨 결과 5개 일치에 보너스 번호가 맞으므로 2등 당첨이다.")
    @Test
    void 로또_2등_당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 3, 4, 5, 6, 9)),
                new Bonus(2));
        assertThat(lottoChecker.getLottoWinning(lotto, winningNumbers)).isEqualTo(SECOND_PRIZE);
    }

    @DisplayName("로또 당첨이 되지 않았다.")
    @Test
    void 로또_미당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 13, 14, 5, 16, 9)),
                new Bonus(2));
        assertThat(lottoChecker.getLottoWinning(lotto, winningNumbers)).isEqualTo(NONE);
    }

}