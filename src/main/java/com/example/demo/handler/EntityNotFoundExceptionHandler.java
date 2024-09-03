package com.example.demo.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EntityNotFoundExceptionHandler {
    @ExceptionHandler (value = EntityNotFoundException.class)
    public ResponseEntity handleException(EntityNotFoundException entityNotFoundException, EntityNotFoundException ex, WebRequest request) {
        return null;
    }

}
