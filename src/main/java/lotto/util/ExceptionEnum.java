package lotto.util;

public enum ExceptionEnum {

    MONEY_UNDER_ZERO("0원 이상 입력해주세요."),
    INVALID_MONEY_UNIT("1000원 단위로 나누어 떨어지지 않습니다."),
    INVALID_NUMBERS_SIZE("로또 번호는 6개입니다."),
    INVALID_NUMBER_RANGE("번호는 1~45 사이 숫자여야 합니다."),
    DUPLICATED_NUMBERS("중복된 번호를 입력할 수 없습니다.");

    private static final String ERROR = "[ERROR] ";
    private String message;

    ExceptionEnum(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
