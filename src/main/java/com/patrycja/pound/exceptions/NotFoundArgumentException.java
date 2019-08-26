package com.patrycja.pound.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You have too small group of zookeepers.")
public class NotFoundArgumentException extends RuntimeException {

    public NotFoundArgumentException(String message) {
        super(message);
    }
}
