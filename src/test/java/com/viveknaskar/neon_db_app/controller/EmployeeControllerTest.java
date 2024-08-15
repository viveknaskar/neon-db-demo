package com.viveknaskar.neon_db_app.controller;

import com.viveknaskar.neon_db_app.data.Employee;
import com.viveknaskar.neon_db_app.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    Employee employee;
    Employee employeeOne;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee employee = new Employee();
        employee.setName("Bruce Wayne");
        employee.setDesignation("software dev");
        employee.setEmail("brucewayne@gmail.com");
        employee.setTechnology("java");
        employee.setId(1L);
        List<Employee> employees = List.of(employee);

        List<Employee> employeeList = employeeController.getEmployees();
        assertNotNull(employeeList);
    }

    @Test
    void testCreateEmployee() {
    }

    @Test
    void testUpdateEmployee() {
    }

    @Test
    void testDeleteEmployee() {
    }
}