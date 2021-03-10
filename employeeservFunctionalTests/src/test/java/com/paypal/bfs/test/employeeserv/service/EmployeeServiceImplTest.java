package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exception.CustomException;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.util.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class EmployeeServiceImplTest {
    @InjectMocks
    @Spy
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Mock
    private Employee employee;

    @Mock
    private EmployeeEntity employeeEntity;

    @Mock
    private EmployeeRepository repository;

    @Mock
    private Address address;

    @Test
    public void findEmployeeByIdTest() {
        int id = 1;
        Mockito.doReturn(employee).when(employeeService).findEmployee(id);
        Assert.assertEquals(employee, employeeService.findEmployeeById(id));
    }

    @Test(expected = CustomException.class)
    public void findEmployeeByIdWhenEmployeeIsNull() {
        int id = 1;
        Mockito.doReturn(null).when(employeeService).findEmployee(id);
        employeeService.findEmployeeById(id);
    }

    @Test
    public void addNewEmployeeTest() {
        Employee newEmployee = this.getEmployee();
        Employee existingEmployee = null;
        Mockito.doReturn(existingEmployee).when(employeeService).findEmployee(newEmployee.getEmpId());
        EmployeeEntity entity = this.getEmployeeEntityBuilder();
        Mockito.when(repository.save(entity)).thenReturn(entity);
        Assert.assertEquals(null, employeeService.addEmployee(newEmployee));
    }

    @Test
    public void addExistingEmployeeTest() {
        Employee newEmployee = this.getEmployee();
        Employee existingEmployee = this.getEmployee();
        EmployeeEntity entity = this.getEmployeeEntityBuilder();
        Mockito.doReturn(existingEmployee).when(employeeService).findEmployee(newEmployee.getEmpId());
        Mockito.when(repository.findByEmpId(existingEmployee.getEmpId())).thenReturn(entity);
        Mockito.doReturn(entity).when(employeeService).addExistingEmpWithUpdatedDetails(entity, newEmployee);
        Mockito.when(repository.save(entity)).thenReturn(entity);

        Assert.assertEquals(Integer.valueOf(entity.getEmpId()), employeeService.addEmployee(newEmployee).getEmpId());
    }

    @Test
    public void getEmployeesTest() {
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        employeeEntityList.add(getEmployeeEntityBuilder());
        Mockito.when(repository.findAll()).thenReturn(employeeEntityList);
        Assert.assertEquals(employeeEntityList.get(0).getFirstName(), employeeService.getEmployees().get(0).getFirstName());
    }

    private EmployeeEntity getEmployeeEntityBuilder() {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setEmpId(1);
        entity.setFirstName("Udit");
        entity.setLastName("Kaushik");
        entity.setDateOfBirth("07/10/2000");

        return entity;
    }

    public Employee getEmployee() {
        String employee = "{\n" +
                "\t\"emp_id\" : 1,\n" +
                "\t\"first_name\" : \"Udit\",\n" +
                "\t\"last_name\" : \"kaushik\",\n" +
                "\t\"date_of_birth\" : \"07/10/1996\",\n" +
                "\t\"address\" : {\n" +
                "\t\t\"line1\" : \"Village - Medpur\",\n" +
                "\t\t\"line2\" : \"Post - Badheri\",\n" +
                "\t\t\"city\" : \"Muzaffarnagar\",\n" +
                "\t\t\"state\" : \"UP\",\n" +
                "\t\t\"zip_code\" : \"251307\"\n" +
                "\t}\n" +
                "}";

        return JsonParser.generalJsonToObject(employee, Employee.class);
    }

    public EmployeeEntity getEmployeeEntity() {
        String employee = "{\n" +
                "\t\"emp_id\" : 1,\n" +
                "\t\"first_name\" : \"Udit\",\n" +
                "\t\"last_name\" : \"kaushik\",\n" +
                "\t\"date_of_birth\" : \"07/10/1996\",\n" +
                "\t\"address\" : {\n" +
                "\t\t\"line1\" : \"Village - Medpur\",\n" +
                "\t\t\"line2\" : \"Post - Badheri\",\n" +
                "\t\t\"city\" : \"Muzaffarnagar\",\n" +
                "\t\t\"state\" : \"UP\",\n" +
                "\t\t\"zip_code\" : \"251307\"\n" +
                "\t}\n" +
                "}";

        return JsonParser.generalJsonToObject(employee, EmployeeEntity.class);
    }
}
