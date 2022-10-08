package com.refactorizando.werbflux.example.exeptions;

public class MissingCardException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;
    public MissingCardException(String message) {
        super(null, message, "MissingCard", "MissingCard");
    }
    public MissingCardException() {
        super(null, "MissingCardException!", "MissingCardException", "MissingCardException");
    }
}
