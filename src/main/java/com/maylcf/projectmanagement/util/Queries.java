package com.maylcf.projectmanagement.util;

public final class Queries {
    public static final String EMPLOYEE_PROJECT = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount" +
            " FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id" +
            " GROUP BY e.first_name, e.last_name" +
            " ORDER BY 3 DESC";
}
