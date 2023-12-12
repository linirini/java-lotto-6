package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.InputEnum.MONEY_INPUT;

public class InputView {

    public String inputMoney(){
        System.out.println(MONEY_INPUT.getMessage());
        String input = readLine();
        return input;
    }

    public String inputWinningLotto(){
        return null;
    }

    public String inputWinningBonus(){
        return null;
    }
}
