package com.katalymov.spring.MVC_Hibernate.controllers;

import com.katalymov.spring.MVC_Hibernate.dao.EmployeeDAO;
import com.katalymov.spring.MVC_Hibernate.entity.Employee;
import com.katalymov.spring.MVC_Hibernate.service.EmployeeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmp",allEmployees);

        return "allEmployees";
    }

    @RequestMapping("/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("emp",employee);
        return "addEmployee";
    }

    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute ("emp") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        System.out.println(employee);
        model.addAttribute("emp", employee);
        return "addEmployee";
    }
}
