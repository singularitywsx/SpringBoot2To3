package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.service.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeVo getEmployeeById(Long id) {
        var vo = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("查無員工檔，id:" + id));
        return  makeEmployeeVo(vo);
    }

    private EmployeeVo makeEmployeeVo(EmployeeEntity entity){
        var vo =new EmployeeVo();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setSex(entity.getSex());
        return vo;
    }

}
