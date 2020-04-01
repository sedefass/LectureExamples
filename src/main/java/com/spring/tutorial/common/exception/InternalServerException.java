package com.spring.tutorial.common.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends FrontEndException {
    private static final long serialVersionUID = 1748263522614323627L;

    public InternalServerException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR, message);
    }
}
