package com.prem.camel.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriggerService {

    @Autowired
    EmployeeService employeeService;

    @PostConstruct
    public void kickOff() throws InterruptedException {
        this.employeeService.exec(true);
    }

}
