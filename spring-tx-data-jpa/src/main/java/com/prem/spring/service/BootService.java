package com.prem.spring.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootService {

    @Autowired
    EmployeeService employeeService;

    @PostConstruct
    public void boot() throws Exception {
        this.employeeService.exec(false);
    }

}
