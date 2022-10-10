package com.katalymov.spring.MVC_Hibernate.dao;

import com.katalymov.spring.MVC_Hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);
}
