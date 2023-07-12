package com.prem.camel.service;

import com.prem.camel.dto.Employee;
import com.prem.camel.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @PostConstruct
    public void init(){
        log.info("Initializing Employee Service");
        Employee e = new Employee();
        e.setId(100);
        e.setName("CamelRaj");
        e.setAddress("Chennai");
        if(!this.repository.existsById(e.getId())) {
            Employee employee = this.repository.save(e);
            log.info("Employee : {}", employee);
            log.info("Record persisted");
        } else {
            log.error("Employee record of id: {} already exist",e.getId());
        }
    }

}
