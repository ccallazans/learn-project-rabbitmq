package com.ccallazans.learn_rabbitmq.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Employee {

    @JsonProperty("employee_id")
    private String employeeId;
    private String name;
    @JsonProperty("birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public Employee() {

    }

    public Employee(String employeeId, String name, LocalDate birthDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId='" + employeeId + '\'' + ", name='" + name + '\'' + ", birthDate='" + birthDate + '\'' + '}';
    }
}
