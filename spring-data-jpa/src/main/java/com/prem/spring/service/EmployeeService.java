package com.prem.spring.service;

import com.prem.spring.dto.Employee;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prem.spring.repository.EmployeeRepository;

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
        e.setName("Ravi");
        e.setAddress("Chennai");
        if(!this.repository.existsById(e.getId())) {
            Employee employee = this.repository.save(e);
            log.info("Employee : {}", employee);
        } else {
            log.error("Employee record of id: {} already exist",e.getId());
        }
    }

}
