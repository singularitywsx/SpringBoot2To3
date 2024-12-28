package com.example.demo.controller;

import com.example.demo.controller.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * http://localhost:8081/employee/1
     * 回傳 {"id":1,"name":"Tom","sex":"M"}
     *
     * http://localhost:8081/employee/99
     * 回傳 查無員工檔，id:{} 99
     * */
    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return makeEmployeeDto(employeeService.getEmployeeById(id));
    }

    private EmployeeDto makeEmployeeDto(EmployeeVo vo){
        var dto =new EmployeeDto();
        dto.setId(vo.getId());
        dto.setName(vo.getName());
        dto.setSex(vo.getSex());
        return dto;
    }



}
