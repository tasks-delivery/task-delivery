package com.task.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PleaseUseBetween6And32CharactersException extends RuntimeException {

    public PleaseUseBetween6And32CharactersException() {
        super("Please use between 6 and 32 characters.");
    }


}
