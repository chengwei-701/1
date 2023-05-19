package com.softusing.jiaokaibo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookFoundException extends RuntimeException {
    public BookFoundException() {
    }

    public BookFoundException(String message) {
        super(message);
    }

    public BookFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookFoundException(Throwable cause) {
        super(cause);
    }
}
