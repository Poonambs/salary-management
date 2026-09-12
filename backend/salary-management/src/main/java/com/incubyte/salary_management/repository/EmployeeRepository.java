package com.incubyte.salary_management.repository;

import com.incubyte.salary_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    
}