package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자가 범위 외일 경우 예외가 발생한다.")
    @Test
    void 범위_외_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 객체를 생성한다..")
    @Test
    void 로또_번호_생성() {
        assertThatNoException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("비교 번호에 대해 해당 로또가 같은 숫자를 몇 개 가지고 있는지 판단한다.")
    @ParameterizedTest
    @CsvSource({"1,3,5,7,9,2,4", "7,8,9,10,11,12,0"})
    void 같은_숫자_갯수(int n1, int n2, int n3, int n4, int n5, int n6, int count) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparison = new Lotto(List.of(n1, n2, n3, n4, n5, n6));
        assertThat(lotto.countSameNumbers(comparison)).isEqualTo(count);
    }

    @DisplayName("해당 번호를 가지고 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void 숫자_포함(int number) {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).hasNumber(number)).isTrue();
    }

    @DisplayName("해당 번호를 가지고 있지 않다.")
    @ParameterizedTest
    @ValueSource(ints = {11, 13, 15})
    void 숫자_미포함(int number) {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).hasNumber(number)).isFalse();
    }

}