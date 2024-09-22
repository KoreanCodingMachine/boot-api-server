package com.example.demo.handler;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.MemberResponseCode;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class EntityNotFoundExceptionHandler {
    @ExceptionHandler (value = EntityNotFoundException.class)
    public ApiResponse handleException(EntityNotFoundException ex, WebRequest request) {
        return ApiResponse.of(MemberResponseCode.MEMBER_NOT_FOUND);
    }

}
