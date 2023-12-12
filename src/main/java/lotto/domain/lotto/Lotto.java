package lotto.domain.lotto;

import static lotto.util.ExceptionEnum.INVALID_NUMBERS_SIZE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        throwIfInvalidNumberSize(numbers);

    }

    private void throwIfInvalidNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE.getMessage());
        }
    }

    public int countSameNumbers(Lotto lotto){
        return -1;
    }

    public boolean hasNumber(int number){
        return false;
    }
}
