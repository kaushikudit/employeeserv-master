package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dto.EmployeeDto;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-10T21:36:07+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
public class ModelToEntityImpl implements ModelToEntity {

    @Override
    public EmployeeEntity modelToEntity(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        if ( employee.getEmpId() != null ) {
            employeeEntity.setEmpId( employee.getEmpId() );
        }
        employeeEntity.setFirstName( employee.getFirstName() );
        employeeEntity.setLastName( employee.getLastName() );
        employeeEntity.setDateOfBirth( employee.getDateOfBirth() );
        employeeEntity.setAddress( employee.getAddress() );

        return employeeEntity;
    }

    @Override
    public Employee entityToModel(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setEmpId( employeeEntity.getEmpId() );
        employee.setFirstName( employeeEntity.getFirstName() );
        employee.setLastName( employeeEntity.getLastName() );
        employee.setDateOfBirth( employeeEntity.getDateOfBirth() );
        employee.setAddress( employeeEntity.getAddress() );

        return employee;
    }

    @Override
    public List<Employee> entitiesToModels(List<EmployeeEntity> employeeEntities) {
        if ( employeeEntities == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeeEntities.size() );
        for ( EmployeeEntity employeeEntity : employeeEntities ) {
            list.add( entityToModel( employeeEntity ) );
        }

        return list;
    }

    @Override
    public EmployeeDto modelToDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmpId( employee.getEmpId() );
        employeeDto.setFirstName( employee.getFirstName() );
        employeeDto.setLastName( employee.getLastName() );
        employeeDto.setDateOfBirth( employee.getDateOfBirth() );
        employeeDto.setAddress( employee.getAddress() );

        return employeeDto;
    }
}
