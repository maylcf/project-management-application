package com.maylcf.projectmanagement.dao;

import com.maylcf.projectmanagement.dto.EmployeeProject;
import com.maylcf.projectmanagement.entities.Employee;
import com.maylcf.projectmanagement.util.Queries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();

    @Query(nativeQuery = true, value = Queries.EMPLOYEE_PROJECT)
    public List<EmployeeProject> employeeProject();
}
