package com.prem.camel.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@Getter @Setter @ToString
public class Employee {

    @Id
    long id;

    String address;

    String name;

}
