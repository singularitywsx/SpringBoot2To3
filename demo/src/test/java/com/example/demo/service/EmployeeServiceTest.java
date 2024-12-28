package com.example.demo.service;

import com.example.demo.common.Sex;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.respository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testGetEmployeeById() {
        var mockEmployee = new EmployeeEntity();
        mockEmployee.setId(1L);
        mockEmployee.setName("Tom");
        mockEmployee.setSex(Sex.M);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(mockEmployee));

        var actual = employeeService.getEmployeeById(1L);

        Assertions.assertThat(actual).isNotNull().isEqualTo(mockEmployee);
    }

    @Test
    void testGetEmployeeByIdWhenNotFound() {
        when(employeeRepository.findById(999L)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            employeeService.getEmployeeById(999L);
        });
        assertEquals("查無員工檔，id:{} " + 999L, exception.getMessage());
    }
}