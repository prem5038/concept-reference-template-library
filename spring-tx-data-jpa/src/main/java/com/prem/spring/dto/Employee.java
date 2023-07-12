package com.prem.spring.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Getter @Setter @ToString
public class Employee {

    @Id
    long id;

    String address;

    String name;

}
