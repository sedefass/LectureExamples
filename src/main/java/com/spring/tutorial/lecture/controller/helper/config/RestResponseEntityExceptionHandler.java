package com.spring.tutorial.lecture.controller.helper.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {ValidationException.class})
    protected ResponseEntity<Object> handleValidationException(ValidationException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleConverterErrors(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String errorMessage = ex.getMessage();

        if (ex.getCause() != null && ex.getCause().getCause() != null) {
            // gets the nested exception message if there is such an exception
            errorMessage = ex.getCause().getCause().getMessage();
        }

        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<String> errorMessages = new ArrayList<>(constraintViolations.size());

        errorMessages.addAll(constraintViolations.stream()
                .map(constraintViolation -> String.format("%s=%s: %s", constraintViolation.getPropertyPath(),
                        constraintViolation.getInvalidValue(), constraintViolation.getMessage()
                ))
                .collect(Collectors.toList()));

        return handleExceptionInternal(ex, errorMessages, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    // Handles validation exception of payload fields
    protected ResponseEntity<Object> handleMethodArgumentNotValid (MethodArgumentNotValidException ex,
                                                                   HttpHeaders headers,
                                                                   HttpStatus status,
                                                                   WebRequest request) {
        List<String> errorMessages = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorMessages.add(String.format("%s=%s: %s",
                    error.getField(), error.getRejectedValue(), error.getDefaultMessage()));
        }

        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errorMessages.add(String.format("%s: %s", error.getObjectName(), error.getDefaultMessage()));
        }

        return handleExceptionInternal(ex, errorMessages, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
