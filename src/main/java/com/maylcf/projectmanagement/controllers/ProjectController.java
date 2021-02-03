package com.maylcf.projectmanagement.controllers;

import com.maylcf.projectmanagement.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        // this should handle savings the project into the database.
        return "";
    }
}
