package com.starwars.client.exception;


public class InformationNotFound extends  RuntimeException{


    public InformationNotFound() {
    }

    public InformationNotFound(String message) {
        super(message);
    }

    public InformationNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public InformationNotFound(Throwable cause) {
        super(cause);
    }

    public InformationNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
