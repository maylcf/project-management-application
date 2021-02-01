package com.maylcf.projectmanagement.dao;

import com.maylcf.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
