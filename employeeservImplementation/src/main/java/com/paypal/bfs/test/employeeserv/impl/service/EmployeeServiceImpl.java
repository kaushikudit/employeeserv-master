package com.paypal.bfs.test.employeeserv.impl.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.enums.ErrorCode;
import com.paypal.bfs.test.employeeserv.exception.CustomException;
import com.paypal.bfs.test.employeeserv.mapper.ModelToEntity;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeById(int id) {
        try {
            Employee employee = this.findEmployee(id);
            if(Objects.isNull(employee)) {
                throw new CustomException(HttpStatus.NOT_FOUND, ErrorCode.EMPLOYEE_NOT_FOUND.getMessage());
            }

            return employee;
        } catch(CustomException ex) {
            log.error("No Employee with employee id {} is present.");
            throw ex;
        } catch (Exception ex) {
            log.error("Something went wrong while fetching data for employee {}.", id);
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.ERROR_IN_FETCHING_EMPLOYEE_DATA.getMessage());
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        try {
            Employee newEmployee = employee;
            Employee existingEmployee = this.findEmployee(employee.getEmpId());
            if(Objects.nonNull(existingEmployee)) {
                EmployeeEntity employeeEntity = employeeRepository.findByEmpId(employee.getEmpId());
                employeeEntity = this.addExistingEmpWithUpdatedDetails(employeeEntity, newEmployee);
                return ModelToEntity.INSTANCE.entityToModel(employeeRepository.save(employeeEntity));
            } else {
                newEmployee = ModelToEntity.
                        INSTANCE.
                        entityToModel(employeeRepository.save(
                                ModelToEntity.INSTANCE.modelToEntity(newEmployee)));
            }

            return newEmployee;
        } catch (Exception ex) {
            log.error("Something went wrong while adding employee {}", employee);
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.ERROR_IN_ADDING_EMPLOYEE.getMessage());
        }
    }

    @Override
    public List<Employee> getEmployees() {
        try {
            List<Employee> employees = ModelToEntity.
                    INSTANCE.
                    entitiesToModels(employeeRepository.findAll());

            return employees;
        } catch (Exception ex) {
            log.error("Something went wrong while fetching the employees data.");
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.ERROR_IN_FETCHING_EMPLOYEE_DATA.getMessage());
        }
    }

    private EmployeeEntity addExistingEmpWithUpdatedDetails(EmployeeEntity existingEmployee, Employee newEmployee) {
        existingEmployee.setAddress(newEmployee.getAddress());
        existingEmployee.setDateOfBirth(newEmployee.getDateOfBirth());
        existingEmployee.setFirstName(newEmployee.getFirstName());
        existingEmployee.setLastName(newEmployee.getLastName());

        return existingEmployee;
    }

    private Employee findEmployee(int id) {
        return ModelToEntity.
                INSTANCE.
                entityToModel(employeeRepository.findByEmpId(id));
    }
}
