package com.mylearning.exception;

/**
 * ClassName: ApiRequestException
 * Package: com.mylearning.exception
 * Description:
 *
 * @Author: Steven_LIU
 * @Create: 7/6/2023 - 8:38 pm
 * @Version: v1.0
 */
public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
