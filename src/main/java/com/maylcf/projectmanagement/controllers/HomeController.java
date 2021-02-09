package com.maylcf.projectmanagement.controllers;

import com.maylcf.projectmanagement.dao.EmployeeRepository;
import com.maylcf.projectmanagement.dao.ProjectRepository;
import com.maylcf.projectmanagement.dto.EmployeeProject;
import com.maylcf.projectmanagement.entities.Employee;
import com.maylcf.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = projectRepo.findAll();
        List<EmployeeProject> employees = employeeRepo.employeeProject();

        model.addAttribute("projects", projects);
        model.addAttribute("employeeProjects", employees);

        return "main/home";
    }
}
