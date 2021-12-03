package com.example.financeapp.service;

import com.example.financeapp.model.Employee;

public interface EmployeeService {
    // authenticate user's log in credentials
    boolean authenticateEmp(String empId, String empPassword);

    Employee getUserByEmpNum(Long empNum);

    Employee getEmpByEmpId(String empId);
}
