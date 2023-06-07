package com.mylearning.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * ClassName: ApiException
 * Package: com.mylearning.exception
 * Description:
 *
 * @Author: Steven_LIU
 * @Create: 7/6/2023 - 9:02 pm
 * @Version: v1.0
 */
public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
