package com.example.financeapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="employee")
@AttributeOverrides({
    @AttributeOverride(name = "userNum", column = @Column(name = "employee_num")),
    @AttributeOverride(name = "userId", column = @Column(name = "employee_id")),
    @AttributeOverride(name = "userPassword", column = @Column(name = "employee_password"))
})
public class Employee extends UserSuper implements Serializable {

    @Column(name = "employee_name")
    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
