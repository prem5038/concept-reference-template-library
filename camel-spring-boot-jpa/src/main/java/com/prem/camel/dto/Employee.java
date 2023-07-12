package com.prem.camel.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
