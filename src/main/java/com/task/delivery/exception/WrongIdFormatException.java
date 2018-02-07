package com.task.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongIdFormatException extends RuntimeException {

    public WrongIdFormatException() {
        super("Id field must be a number ");
    }

}
