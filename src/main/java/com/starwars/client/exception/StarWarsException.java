package com.starwars.client.exception;

public class StarWarsException extends   RuntimeException{


    public StarWarsException() {
    }

    public StarWarsException(String message) {
        super(message);
    }

    public StarWarsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StarWarsException(Throwable cause) {
        super(cause);
    }

    public StarWarsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
