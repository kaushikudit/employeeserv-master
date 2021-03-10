package com.paypal.bfs.test.employeeserv.api.service;

import javax.validation.ConstraintValidatorContext;

public interface CustomValidation {

  boolean isValid(ConstraintValidatorContext context);

}
