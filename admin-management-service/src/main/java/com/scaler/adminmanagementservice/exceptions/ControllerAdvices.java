package com.scaler.adminmanagementservice.exceptions;

import com.scaler.adminmanagementservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> notFoundExceptionHandler(NotFoundException notFoundExceptions) {
        return new ResponseEntity<>(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundExceptions.getMessage()),
                HttpStatus.NOT_FOUND

        );
    }
}
