package com.paypal.bfs.test.employeeserv.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionModel {
    private String errorMessage;
    private int statusCode;
}
