package com.maylcf.projectmanagement.dao;

import com.maylcf.projectmanagement.dto.ChartData;
import com.maylcf.projectmanagement.entities.Project;
import com.maylcf.projectmanagement.util.Queries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = Queries.PROJECT_STATUS)
    public List<ChartData> getProjectStatus();
}
