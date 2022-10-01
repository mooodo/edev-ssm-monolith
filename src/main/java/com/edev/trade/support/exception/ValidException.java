package com.edev.trade.support.exception;

public class ValidException extends RuntimeException {
    public ValidException() {
        super();
    }
    public ValidException(String message) {
        super(message);
    }
    public ValidException(String message, Object...args) {
        super(String.format(message, args));
    }
}
