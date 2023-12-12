package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("총 상금액을 반환한다.")
    @Test
    void 총_상금_반환() {
        List<WinningEnum> winningEnums = getWinningEnums();
        assertThat(new WinningResult(winningEnums).getTotalPrize()).isEqualTo(1505000);
    }

    @DisplayName("불변 형태로 당첨 결과 목록을 반환한다.")
    @Test
    void 불변_당첨_결과_반환() {
        List<WinningEnum> winningEnums = getWinningEnums();
        assertThatThrownBy(
                () -> new WinningResult(winningEnums).getWinnings()
                        .put(WinningEnum.FIFTH_PRIZE, 1)).isInstanceOf(Exception.class);
    }

    private static List<WinningEnum> getWinningEnums() {
        List<WinningEnum> winningEnums = new ArrayList<>();
        winningEnums.add(WinningEnum.THIRD_PRIZE);
        winningEnums.add(WinningEnum.FIFTH_PRIZE);
        return winningEnums;
    }

}