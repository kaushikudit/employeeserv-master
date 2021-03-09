package com.paypal.bfs.test.employeeserv.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ModelToEntity {
    ModelToEntity INSTANCE = Mappers.getMapper(ModelToEntity.class);
    ObjectMapper objectMapper = new ObjectMapper();

    EmployeeEntity modelToEntity(Employee employee);
    Employee entityToModel(EmployeeEntity employeeEntity);
    List<Employee> entitiesToModels(List<EmployeeEntity> employeeEntities);
}
