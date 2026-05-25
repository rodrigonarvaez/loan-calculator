package com.loancalc;

public class InvalidLoanException extends RuntimeException {
    public InvalidLoanException(String message) {
        super(message);
    }
}
