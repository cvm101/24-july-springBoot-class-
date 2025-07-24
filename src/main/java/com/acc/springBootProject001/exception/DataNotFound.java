package com.acc.springBootProject001.exception;

public class DataNotFound extends Exception{
    public DataNotFound(String message) {
        super(message);
    }

    public DataNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFound(Throwable cause) {
        super(cause);
    }
}
