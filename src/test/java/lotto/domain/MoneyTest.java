package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("0원 이하 금액을 입력할 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void _0원_이하_예외(int amount) {
        assertThatThrownBy(() -> new Money(amount)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아닌 금액을 입력할 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 14500})
    void _1000원_단위_아닌_예외(int amount) {
        assertThatThrownBy(() -> new Money(amount)).isInstanceOf(IllegalArgumentException.class);
    }

}