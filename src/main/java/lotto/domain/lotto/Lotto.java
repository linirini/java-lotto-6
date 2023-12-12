package lotto.domain.lotto;

import static lotto.util.ExceptionEnum.DUPLICATED_NUMBERS;
import static lotto.util.ExceptionEnum.INVALID_NUMBERS_SIZE;
import static lotto.util.ExceptionEnum.INVALID_NUMBER_RANGE;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        throwIfInvalidNumberSize(numbers);
        throwIfInvalidNumberRange(numbers);
        throwIfDuplicatedNumbers(numbers);
    }

    private void throwIfInvalidNumberSize(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE.getMessage());
        }
    }

    private void throwIfInvalidNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_NUMBER || number > END_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage())
            }
        }
    }

    private void throwIfDuplicatedNumbers(List<Integer> numbers) {
        int uniqueCount = numbers.stream().collect(Collectors.toSet()).size();
        if (numbers.size() != uniqueCount) {
            throw new IllegalArgumentException(DUPLICATED_NUMBERS.getMessage());
        }
    }

    public int countSameNumbers(Lotto lotto) {
        int sameCount = 0;
        for (Integer number : lotto.numbers) {
            if (this.numbers.contains(number)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

}
