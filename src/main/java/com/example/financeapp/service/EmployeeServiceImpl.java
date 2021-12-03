package com.example.financeapp.service;

import com.example.financeapp.model.Employee;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean authenticateEmp(String empId, String empPassword) {
        boolean result = false;
        System.out.println("HERE");
        Optional<Employee> user = employeeRepository.findByUserId(empId);
        if (user.isPresent()) {
            if (user.get().getUserPassword().equals(empPassword)) {
                result =true;
            } else {
                result = false;
            }
        } else {result = false;}
        return result;
    }

    @Override
    public Employee getUserByEmpNum(Long empNum) {
        Optional<Employee> optional = employeeRepository.findById(empNum);
        Employee user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for employee number: " + empNum);
        }
        return user;
    }

    @Override
    public Employee getEmpByEmpId(String empId) {
        Optional<Employee> optional = employeeRepository.findByUserId(empId);
        Employee user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for id: " + empId);
        }
        return user;
    }
}
