package com.paypal.bfs.test.employeeserv.exception;

import lombok.Data;

import java.util.List;

@Data
public class ConstraintViolationException extends RuntimeException {

  private List<String> violations;

  public ConstraintViolationException(final List<String> violations) {
    this.violations = violations;
  }

}
