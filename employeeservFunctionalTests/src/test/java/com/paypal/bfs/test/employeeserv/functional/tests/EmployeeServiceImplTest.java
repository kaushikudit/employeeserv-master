package com.paypal.bfs.test.employeeserv.functional.tests;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class EmployeeServiceImplTest {
    @InjectMocks
    @Spy
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Mock
    private Employee employee;

    @Test
    public void findEmployeeByIdTest() {
        int id = 1;
        Mockito.doReturn(employee).when(employeeService).findEmployee(id);
        Assert.assertEquals(employee, employeeService.findEmployeeById(id));
    }
}
