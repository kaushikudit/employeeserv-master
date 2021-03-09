package com.paypal.bfs.test.employeeserv.api.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     *
     * @param id
     * @return {@link Employee}
     */
    Employee findEmployeeById(final int id);


    /**
     *
     * @param employee
     * add {@link Employee}
     * @return added Employee object
     */
    Employee addEmployee(final Employee employee);

    /**
     *
     * @return {@link List} of {@link Employee} present in the system
     */
    List<Employee> getEmployees();
}
