package com.prem.camel.service;

import com.prem.camel.dto.Employee;
import com.prem.camel.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;


    @Transactional
    public void exec(boolean breakTx) throws InterruptedException {
        log.info("Initializing Employee Service");
        int count=0;
        int genId=1000;
        while(count<10) {
            count++;
            genId++;
            Employee e = new Employee();
            e.setId(genId);
            e.setName("CamelRavi");
            e.setAddress("Chennai");
            if (!this.repository.existsById(e.getId())) {
                Employee employee = this.repository.save(e);
                log.info("Employee : {}", employee);
            } else {
                log.error("Employee record of id: {} already exist", e.getId());
            }

            if(breakTx && count > 5){
                log.info("Cool down for 30s");
                Thread.sleep(30*1000);
                log.info("Resumed");
                throw new RuntimeException("Break the transaction");
            }
        }
    }

}
