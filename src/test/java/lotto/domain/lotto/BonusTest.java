package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    @DisplayName("보너스 번호 예외 처리 - 범위 내 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 50})
    void 범위_외_숫자_오류(int number) {
        assertThrows(IllegalArgumentException.class, () -> new Bonus(number));
    }

    @DisplayName("보너스 번호 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 19, 45})
    void 보너스_생성(int number) {
        assertDoesNotThrow(() -> new Bonus(number));
    }

}