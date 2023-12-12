package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 목록을 문자열 형태로 반환한다.")
    @Test
    void 로또_문자열_목록_반환() {
        Lottos lottos = getLottos();
        assertThat(lottos.getLottosNumbers()).hasSize(2)
                .contains("[1, 2, 3, 4, 5, 6]", "[41, 42, 43, 44, 45, 36]");
    }


    private static Lottos getLottos() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(41, 42, 43, 44, 45, 36))));
        return lottos;
    }

}