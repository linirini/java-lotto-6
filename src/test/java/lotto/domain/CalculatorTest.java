package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @DisplayName("상금과 구입 금액으로 수익율을 소숫점 둘째자리에서 반올림하여 반환한다.")
    @Test
    void 수익율_계산() {
        assertThat(calculator.getEarningRate(5000, new Money(8000))).isEqualTo("62.5");
    }

}