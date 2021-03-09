package com.paypal.bfs.test.employeeserv.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {CustomException.class})
    @ResponseBody
    protected ResponseEntity<?> handleCustomException(
            final CustomException ex) {
        log.error("Custom exception {}", ex.getErrorMessage());
        ExceptionModel exceptionModel = ExceptionModel.builder()
                .statusCode(ex.getStatusCode().value())
                .errorMessage(ex.getErrorMessage())
                .build();
        return ResponseEntity.status(ex.getStatusCode()).body(exceptionModel);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<?> handleException(
            final Exception ex) {
        log.error("error {}", ex);
        ExceptionModel exceptionModel = ExceptionModel.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorMessage("Something went wrong.").build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionModel);
    }
}
