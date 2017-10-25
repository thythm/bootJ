package com.example.execption;

/**
 * @author majunjie
 * @description 自定义异常，便于分辨，是否人为抛出
 * @date 2017/10/25 11:06
 */
public class MMException extends RuntimeException{

    public MMException() {
        super();
    }

    public MMException(String message) {
        super(message);
    }

    public MMException(String message, Throwable cause) {
        super(message, cause);
    }

    public MMException(Throwable cause) {
        super(cause);
    }

    protected MMException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
