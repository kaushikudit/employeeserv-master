package com.paypal.bfs.test.employeeserv.dto;

import com.paypal.bfs.test.employeeserv.annotation.ValidateRequest;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

import com.paypal.bfs.test.employeeserv.api.service.CustomValidation;
import com.paypal.bfs.test.employeeserv.validator.EmployeeDtoValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintValidatorContext;


@ValidateRequest
@Getter
@Setter
public class EmployeeDto extends Employee implements CustomValidation {
    @Override
    public boolean isValid(ConstraintValidatorContext context) {
        if(EmployeeDtoValidator.areFieldsMissing(this, context)) {
            return false;
        }
        return true;
    }
}
