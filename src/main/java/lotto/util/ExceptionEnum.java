package lotto.util;

public enum ExceptionEnum {

    MONEY_UNDER_ZERO("0원 이상 입력해주세요."),
    INVALID_MONEY_UNIT("1000원 단위로 나누어 떨어지지 않습니다.");

    private static final String ERROR = "[ERROR] ";
    private String message;

    ExceptionEnum(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
