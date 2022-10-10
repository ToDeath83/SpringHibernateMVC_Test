package com.katalymov.spring.MVC_Hibernate.service;

import com.katalymov.spring.MVC_Hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
}
