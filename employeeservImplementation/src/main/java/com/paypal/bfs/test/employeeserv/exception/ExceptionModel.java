package com.paypal.bfs.test.employeeserv.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExceptionModel {
    private String errorMessage;
    private int statusCode;
    private List<String> violations;
}
