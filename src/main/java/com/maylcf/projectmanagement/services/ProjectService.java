package com.maylcf.projectmanagement.services;

import com.maylcf.projectmanagement.dao.ProjectRepository;
import com.maylcf.projectmanagement.dto.ChartData;
import com.maylcf.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public List<ChartData> getProjectStatus() {
        return projectRepository.getProjectStatus();
    }
}
