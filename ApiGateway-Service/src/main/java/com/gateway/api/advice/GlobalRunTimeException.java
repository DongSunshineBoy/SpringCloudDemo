package com.gateway.api.advice;


public class GlobalRunTimeException extends RuntimeException {
    private String message;
    private Integer code;

    public GlobalRunTimeException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
