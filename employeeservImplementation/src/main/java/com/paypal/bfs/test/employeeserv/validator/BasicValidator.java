package com.paypal.bfs.test.employeeserv.validator;

import com.google.common.base.CaseFormat;
import com.paypal.bfs.test.employeeserv.exception.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class BasicValidator {

  /**
   * The function that would validate the input object.
   * @param target the target object that needs to be validated.
   */
  public void validate(final Object target) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    List<String> errors = new ArrayList<String>();
    if (target instanceof List<?>) {
      for (Object obj : (List<?>) target) {
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        for (ConstraintViolation<?> violation : violations) {
          StringBuilder sb = new StringBuilder();
          sb.append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
              violation.getPropertyPath().toString())).append(" ").append(violation.getMessage());
          errors.add(sb.toString());
        }
      }
    } else {
      Set<ConstraintViolation<Object>> violations = validator.validate(target);

      for (ConstraintViolation<?> violation : violations) {
        StringBuilder sb = new StringBuilder();
        sb.append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
            violation.getPropertyPath().toString())).append(" ").append(violation.getMessage());
        errors.add(sb.toString());
      }
    }
    if (!errors.isEmpty()) {
      log.error("Validation Ended With Errors {}.", errors);
      throw new ConstraintViolationException(errors);
    } else {
      log.info("Validation Ended Without Exception");
    }
  }


}
