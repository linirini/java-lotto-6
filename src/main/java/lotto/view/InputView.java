package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.ExceptionEnum.NOT_NUMBER_FORMAT;
import static lotto.util.InputEnum.PURCHASE_AMOUNT_INPUT;
import static lotto.util.InputEnum.WINNING_NUMBERS_INPUT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Amount;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;

public class InputView{

    public static Amount inputPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT.message());
        int amount = 0;
        try{
            amount = Integer.parseInt(readLine());
        } catch (NumberFormatException NFE){
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.message());
        }
        return new Amount(amount);
    }

    public static Lotto inputWinningNumbers(){
        System.out.println(WINNING_NUMBERS_INPUT.message());
        List<Integer> numbers = new ArrayList<>();
        try{
            numbers = Arrays.asList(readLine().split(",")).stream().map(s -> Integer.parseInt(s)).toList();
        } catch (NumberFormatException NPE){
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.message());
        }
        return new Lotto(numbers);
    }

    public static Bonus inputBonusNumber(){
        return null;
    }

}
