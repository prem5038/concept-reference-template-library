package com.prem.spring.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void execute(boolean breakTx) throws InterruptedException {
        log.info("Initializing Employee Service");
        int count=0;
        int genId=100;
        while(count<10) {
            genId++;
            count++;
            String query = "insert into pandora.employee (id, \"name\", address) values ("+genId+", 'Baby', 'China')";
            this.jdbcTemplate.execute(query);
            log.info("Data persisted");

            if(breakTx && count < 5){
                log.info("Cool down for 30s");
                Thread.sleep(30*1000);
                log.info("Resumed from sleep");
                throw new RuntimeException("Break the transaction");
            }
        }
    }

}
