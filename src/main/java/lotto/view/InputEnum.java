package lotto.view;

public enum InputEnum {

    MONEY_INPUT("구입금액을 입력해 주세요."),
    WINNING_LOTTO_INPUT("당첨 번호를 입력해 주세요."),
    WINNING_BONUS_INPUT("보너스 번호를 입력해 주세요.");

    private final String message;

    InputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
