package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation class for employee resource.
 */
@RestController
@Slf4j
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> employeeGetById(final int id) {
        return ResponseEntity.
                status(HttpStatus.OK).
                body(employeeService.findEmployeeById(id));
    }

    @Override
    public ResponseEntity<Employee> addEmployee(final Employee employee) {
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(employeeService.addEmployee(employee));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.
                status(HttpStatus.OK).
                body(employeeService.getEmployees());
    }
}
