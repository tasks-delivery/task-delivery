package com.task.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SomeoneAlreadyHasThatUsernameException extends RuntimeException {

    public SomeoneAlreadyHasThatUsernameException(String username) {
        super("Someone already has that username " + username);
    }

}
