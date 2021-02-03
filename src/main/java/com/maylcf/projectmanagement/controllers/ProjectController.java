package com.maylcf.projectmanagement.controllers;

import com.maylcf.projectmanagement.dao.ProjectRepository;
import com.maylcf.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository repository;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = repository.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        repository.save(project);

        //use a redirect to prevent duplicate submissions.
        return "redirect:/projects/new";
    }
}
