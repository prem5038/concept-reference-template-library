package com.prem.spring.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){
        log.info("Initializing Employee Service");
        this.jdbcTemplate.execute("insert into pandora.employee (id, \"name\", address) values (202, 'Baby', 'China')");
        log.info("Data persisted");
    }

}
