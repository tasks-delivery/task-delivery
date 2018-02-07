package com.task.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictWithExistingProjectException extends RuntimeException {

    public ConflictWithExistingProjectException(String projectName) {
        super("Conflict with existing project " + projectName);
    }

}
