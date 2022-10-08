package com.refactorizando.werbflux.example.exeptions;

public class MissingRentCardException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;
    public MissingRentCardException(String message) {
        super(null, message, "MissingRentCard", "MissingRentCard");
    }
    public MissingRentCardException() {
        super(null, "MissingRentCardException!", "MissingRentCardException", "MissingRentCardException");
    }
}
