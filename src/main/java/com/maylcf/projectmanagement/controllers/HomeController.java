package com.maylcf.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maylcf.projectmanagement.dao.EmployeeRepository;
import com.maylcf.projectmanagement.dao.ProjectRepository;
import com.maylcf.projectmanagement.dto.ChartData;
import com.maylcf.projectmanagement.dto.EmployeeProject;
import com.maylcf.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    // Access a value from application.properties
    @Value("${version}")
    private String version;

    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        // application version.
        model.addAttribute("versionNumber", version);

        // project info
        List<Project> projects = projectRepo.findAll();
        model.addAttribute("projects", projects);

        // employee info
        List<EmployeeProject> employees = employeeRepo.employeeProject();
        model.addAttribute("employeeProjects", employees);

        // project status info
        String projectStatusJson = getProjectStatusJsonData();
        model.addAttribute("projectStatus", projectStatusJson);

        return "main/home";
    }

    public String getProjectStatusJsonData() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        List<ChartData> projectData = projectRepo.getProjectStatus();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(projectData);
    }
}
