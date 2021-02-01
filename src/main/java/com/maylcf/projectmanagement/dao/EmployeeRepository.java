package com.maylcf.projectmanagement.dao;

import com.maylcf.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
