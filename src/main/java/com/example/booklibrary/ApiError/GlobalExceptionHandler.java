package com.example.booklibrary.ApiError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        String message = ex.getMessage();
        if (message != null)
            return new ResponseEntity<>(String.format("%s is not found!", message), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("record is not found!", HttpStatus.NOT_FOUND);
    }
}
