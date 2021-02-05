package com.maylcf.projectmanagement;

import com.maylcf.projectmanagement.dao.EmployeeRepository;
import com.maylcf.projectmanagement.dao.ProjectRepository;
import com.maylcf.projectmanagement.entities.Employee;
import com.maylcf.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class ProjectManagementApplication {

    @Autowired
    EmployeeRepository employeeRepo;

    @Autowired
    ProjectRepository projectRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Create Employees

            Employee employee1 = new Employee("John", "Snow", "John.Snow@gmail.com");
            Employee employee2 = new Employee("Jaime", "Lannister", "Jaime.Lannister@gmail.com");
            Employee employee3 = new Employee("Daenerys", "Targaryen", "Daenerys.Targaryen@gmail.com");
            Employee employee4 = new Employee("Arya", "Stark", "Arya.Stark@gmail.com");
            Employee employee5 = new Employee("Theon", "Greyjoy", "Theon.Greyjoy@gmail.com");
            Employee employee6 = new Employee("Tyrion", "Lannister", "Tyrion.Lannister@gmail.com");
            Employee employee7 = new Employee("Cersei", "Lannister", "Cersei.Lannister@gmail.com");

            // Create Projects

            Project project1 = new Project("NY Chapter", "NOT_STARTED", "Development of NY's Chapter");
            Project project2 = new Project("Company Website", "COMPLETED", "Creation of Company Website");
            Project project3 = new Project("Mobile App", "IN_PROGRESS", "Creation of Company App");
            Project project4 = new Project("Toronto Chapter", "IN_PROGRESS", "Development of Toronto's Chapter");

            // Relationship

            project1.addEmployee(employee1);
            project1.addEmployee(employee2);
            project2.addEmployee(employee3);
            project3.addEmployee(employee1);
            project4.addEmployee(employee1);
            project4.addEmployee(employee3);

            employee1.setProjects(Arrays.asList(project1, project3, project4));
            employee2.setProjects(Collections.singletonList(project1));
            employee3.setProjects(Arrays.asList(project2, project4));

            // Save to database

            employeeRepo.save(employee1);
            employeeRepo.save(employee2);
            employeeRepo.save(employee3);
            employeeRepo.save(employee4);
            employeeRepo.save(employee5);
            employeeRepo.save(employee6);
            employeeRepo.save(employee7);

            projectRepo.save(project1);
            projectRepo.save(project2);
            projectRepo.save(project3);
            projectRepo.save(project4);
        };
    }
}
