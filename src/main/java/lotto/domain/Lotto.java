package lotto.domain;

import java.util.List;

public class Lotto{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto issueRandomLotto(){
        return new Lotto(RandomNumberGenerator.createUniqueRandomNumbers());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void determineWinnings(Lotto winningNumbers){

    }

    public int countSameNumber(Lotto winningNumbers){
        return -1;
    }

}
