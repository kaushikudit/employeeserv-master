package com.paypal.bfs.test.employeeserv.annotation;

import com.paypal.bfs.test.employeeserv.impl.service.CustomRequestValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomRequestValidator.class)
public @interface ValidateRequest {

  /**
   * default message.
   * @return string
   */
  String message() default "{}";

  /**
   * groups.
   * @return groups
   */
  Class<?>[] groups() default {};

  /**
   * Payload.
   * @return payload
   */
  Class<? extends Payload>[] payload() default {};

}

