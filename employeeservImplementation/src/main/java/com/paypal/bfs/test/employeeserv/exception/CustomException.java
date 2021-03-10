package com.paypal.bfs.test.employeeserv.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class CustomException extends RuntimeException {
    private String errorMessage;
    private HttpStatus statusCode;

    public CustomException(HttpStatus statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public HttpStatus getStatusCode() {
        return this.statusCode;
    }

}

