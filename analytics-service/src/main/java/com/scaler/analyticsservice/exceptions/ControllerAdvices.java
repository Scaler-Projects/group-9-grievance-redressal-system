package com.scaler.analyticsservice.exceptions;


import com.scaler.analyticsservice.dtos.responses.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionResponseDto> handleNotFoundException(
            NotFoundException notFoundException
    ) {
        return new ResponseEntity(
                new ExceptionResponseDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<ExceptionResponseDto> handleArrayIndexOutOfBound(
            ArrayIndexOutOfBoundsException notFoundException
    ) {
        return new ResponseEntity(
                new ExceptionResponseDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}