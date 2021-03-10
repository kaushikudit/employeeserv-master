package com.paypal.bfs.test.employeeserv.impl.service;

import com.paypal.bfs.test.employeeserv.annotation.ValidateRequest;
import com.paypal.bfs.test.employeeserv.api.service.CustomValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomRequestValidator implements ConstraintValidator<ValidateRequest, Object> {

  private static final Logger LOG = LogManager.getLogger();

  @Override
  public void initialize(final ValidateRequest constraintAnnotation) {

  }

  @Override
  public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    LOG.info("Checking is valid");
    if (value instanceof CustomValidation) {
      LOG.info("Object has CustomValidation Implementation");
      return ((CustomValidation) value).isValid(context);
    }
    return true;
  }

}
