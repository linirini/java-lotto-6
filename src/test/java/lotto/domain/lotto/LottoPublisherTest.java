package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPublisherTest {

    private LottoPublisher lottoPublisher;

    @BeforeEach
    void init() {
        lottoPublisher = new LottoPublisher();
    }

    @DisplayName("구입 금액만큼 로또를 발행한다.")
    @ParameterizedTest
    @CsvSource({"1000,1", "8000,8", "154000,154"})
    void 로또_발행(int amount, int count) {
        assertThat(
                lottoPublisher.publishLottoByMoney(new Money(amount)).getLottosCount()).isEqualTo(
                count);
    }

}