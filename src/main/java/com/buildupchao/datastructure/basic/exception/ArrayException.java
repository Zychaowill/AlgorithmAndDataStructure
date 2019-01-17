package com.buildupchao.datastructure.basic.exception;

/**
 * Created by yachao on 17/11/25.
 */
public class ArrayException extends RuntimeException {

    public ArrayException() {
        super();
    }

    public ArrayException(String message) {
        super(message);
    }

    public ArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}
