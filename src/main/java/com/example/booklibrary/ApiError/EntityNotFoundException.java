package com.example.booklibrary.ApiError;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(Object obj) {
        super(String.valueOf(obj));
    }
}
