package com.viveknaskar.neon_db_app.service.impl;

import com.viveknaskar.neon_db_app.data.Employee;
import com.viveknaskar.neon_db_app.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setId(1L);
        employee.setName("Bruce Wayne");
        employee.setDesignation("software dev");
        employee.setEmail("brucewayne@gmail.com");
        employee.setTechnology("java");
    }

    @Test
    void testGetAllEmployees() {
        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Clark Kent");
        List<Employee> employees = Arrays.asList(employee, employee2);
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> result = employeeService.getAllEmployees();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Bruce Wayne", result.get(0).getName());
        assertEquals("Clark Kent", result.get(1).getName());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void testCreateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee result = employeeService.createEmployee(employee);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Bruce Wayne", result.getName());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testUpdateEmployee() {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(1L);
        updatedEmployee.setName("Bruce Wayne Updated");
        updatedEmployee.setDesignation("senior dev");
        updatedEmployee.setEmail("brucewayne@waynecorp.com");
        updatedEmployee.setTechnology("python");

        when(employeeRepository.save(any(Employee.class))).thenReturn(updatedEmployee);
        Employee result = employeeService.updateEmployee(1L, updatedEmployee);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Bruce Wayne Updated", result.getName());
        assertEquals("senior dev", result.getDesignation());
        assertEquals("brucewayne@waynecorp.com", result.getEmail());
        assertEquals("python", result.getTechnology());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1L);
        employeeService.deleteEmployee(1L);
        verify(employeeRepository, times(1)).deleteById(1L);
    }
}
