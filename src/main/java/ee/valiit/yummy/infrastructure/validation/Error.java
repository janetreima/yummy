package ee.valiit.yummy.infrastructure.validation;

import lombok.Getter;

@Getter

public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool, palun proovi uuesti :)", 111),
    NO_RECIPES_FOUND("Ei leidnud sobivaid retsepte. Muuda filtrit ja proovi uuesti :)", 222);

    private final String message;
    private final Integer errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}