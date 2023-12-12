package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.InputEnum.MONEY_INPUT;
import static lotto.view.InputEnum.WINNING_BONUS_INPUT;
import static lotto.view.InputEnum.WINNING_LOTTO_INPUT;

public class InputView {

    public String inputMoney() {
        System.out.println(MONEY_INPUT.getMessage());
        String input = readLine();
        return input;
    }

    public String inputWinningLotto() {
        System.out.println(WINNING_LOTTO_INPUT.getMessage());
        String input = readLine();
        return input;
    }

    public String inputWinningBonus() {
        System.out.println(WINNING_BONUS_INPUT.getMessage());
        String input = readLine();
        return input;
    }

}
