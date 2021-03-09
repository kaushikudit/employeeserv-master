package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") int id);

    // ----------------------------------------------------------
    // TODO - add a new operation for creating employee resource.
    // ----------------------------------------------------------

    @RequestMapping(value = "/v1/bfs/employee", method = RequestMethod.POST)
    ResponseEntity<Employee> addEmployee(@RequestBody final Employee employee);


    /**
     *
     * @return {@link List} of {@link Employee} present in the system
     */
    @RequestMapping(value = "/retrieve/get", method = RequestMethod.GET)
    ResponseEntity<List<Employee>> getEmployees();
}
