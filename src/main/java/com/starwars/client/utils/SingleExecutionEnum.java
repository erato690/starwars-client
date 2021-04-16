package com.starwars.client.utils;

public enum SingleExecutionEnum {

    LOAD_STARSHIP(1),
    LOAD_FILM(2);
    private int code;

    SingleExecutionEnum (int code){
        this.code =code;
    }

    public int getCode() {
        return code;
    }
}
