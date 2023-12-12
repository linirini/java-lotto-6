package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class RandomNumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;

    public List<Integer> createSixRandomNumbers() {
        return pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }

}
