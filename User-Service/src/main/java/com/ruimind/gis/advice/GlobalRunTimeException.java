package com.ruimind.gis.advice;

import lombok.Data;

@Data
public class GlobalRunTimeException extends RuntimeException {
    private String message;
    private Integer code;

    public GlobalRunTimeException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
