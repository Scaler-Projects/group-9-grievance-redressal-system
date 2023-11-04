package com.scaler.analyticsservice.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionResponseDto {
    private HttpStatus errorCode;
    private String message;
    public ExceptionResponseDto(HttpStatus status, String message) {
        this.errorCode = status;
        this.message = message;
    }
}
