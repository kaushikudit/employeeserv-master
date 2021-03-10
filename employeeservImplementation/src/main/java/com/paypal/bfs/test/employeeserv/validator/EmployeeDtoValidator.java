package com.paypal.bfs.test.employeeserv.validator;

import com.paypal.bfs.test.employeeserv.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@Slf4j
public class EmployeeDtoValidator {
    public static boolean areFieldsMissing(EmployeeDto dto, ConstraintValidatorContext context) {
        log.info("Validation started for add Employee request.");

        boolean isConstraintViolated = false;

        if(StringUtils.isEmpty(dto.getFirstName())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "First name cannot be empty or null.")
                    .addConstraintViolation();
            isConstraintViolated = true;
        } else {
            if(dto.getFirstName().length() < 1 || dto.getFirstName().length() > 255) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Length of first name must be in between 1 and 255.")
                        .addConstraintViolation();
                isConstraintViolated = true;
            }
        }
        if(StringUtils.isEmpty(dto.getLastName())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Last name cannot be empty or null.")
                    .addConstraintViolation();
            isConstraintViolated = true;
        } else {
            if(dto.getLastName().length() < 1 || dto.getLastName().length() > 255) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Length of last name must be in between 1 and 255.")
                        .addConstraintViolation();
                isConstraintViolated = true;
            }
        }
        if(StringUtils.isEmpty(dto.getEmpId())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Employee id cannot be empty or null.")
                    .addConstraintViolation();
            isConstraintViolated = true;
        }
        if(Objects.isNull(dto.getAddress())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Address is missing.")
                    .addConstraintViolation();
            isConstraintViolated = true;
        }
        else if(Objects.nonNull(dto.getAddress())) {
            String line1 = dto.getAddress().getLine1();
            String city = dto.getAddress().getCity();
            String country = dto.getAddress().getCountry();
            String state = dto.getAddress().getState();
            String zipCode = dto.getAddress().getZipCode();
            if(StringUtils.isEmpty(line1)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Line1 in address field is missing.")
                        .addConstraintViolation();
                isConstraintViolated = true;
            }
            if(StringUtils.isEmpty(city)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "City in address field is missing.")
                        .addConstraintViolation();
                isConstraintViolated = true;
            }
            if(StringUtils.isEmpty(state)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "State in address field is missing.")
                        .addConstraintViolation();
                isConstraintViolated = true;
            }
            if(StringUtils.isEmpty(country)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Country in address field is missing.")
                        .addConstraintViolation();
                isConstraintViolated = true;
            }
            if(StringUtils.isEmpty(zipCode)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "zipcode in address field is missing.")
                        .addConstraintViolation();
                isConstraintViolated = true;
            } else {
                if(!zipCode.matches("^[1-9][0-9]{5}$")) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(
                            "Please enter a correct zipcode.")
                            .addConstraintViolation();
                    isConstraintViolated = true;
                }
            }
        }

        return isConstraintViolated;
    }
}
