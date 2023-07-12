package com.prem.camel.service;

import com.prem.camel.dto.Employee;
import com.prem.camel.repository.EmployeeRepository;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        } else {
            log.error("Employee record of id: {} already exist",e.getId());
        }
    }

}
