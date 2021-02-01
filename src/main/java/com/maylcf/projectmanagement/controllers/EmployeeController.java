package com.maylcf.projectmanagement.controllers;

import com.maylcf.projectmanagement.dao.EmployeeRepository;
import com.maylcf.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        repository.save(employee);
        return "redirect:/employees/new";
    }
}