package ee.valiit.yummy.infrastructure.validation;

import lombok.Getter;

@Getter

public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool, palun proovi uuesti :)", 111);

    private final String message;
    private final Integer errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}