package com.spring.tutorial.common.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends FrontEndException {
    private static final long serialVersionUID = -4579141063354158703L;

    public ResourceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, ErrorCode.RESOURCE_NOT_FOUND, message);
    }
}
