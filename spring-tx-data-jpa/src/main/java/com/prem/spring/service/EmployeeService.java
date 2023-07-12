package com.prem.spring.service;

import com.prem.spring.dto.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prem.spring.repository.EmployeeRepository;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Transactional
    public void exec(boolean breakTx) throws InterruptedException {
        int genId = 100;
        int count = 0;
        while(count < 10) {
            log.info("Initializing Employee Service");
            genId++;
            count++;
            Employee e = new Employee();
            e.setId(genId);
            e.setName("Ravi");
            e.setAddress("Chennai");
            if (!this.repository.existsById(e.getId())) {
                Employee employee = this.repository.save(e);
                log.info("Employee : {}", employee);
            } else {
                log.error("Employee record of id: {} already exist", e.getId());
            }
            if(breakTx && count == 5){
                log.info("Cool down for 30s ...");
                Thread.sleep(30*1000);
                log.info("Resumed from timeout");
                throw new RuntimeException("Breaking Transactions");
            }
        }
    }

}
