package com.incubyte.salary_management.config;

import com.incubyte.salary_management.entity.Employee;
import com.incubyte.salary_management.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedEmployees(EmployeeRepository employeeRepository) {

        return args -> {

            if (employeeRepository.count() >= 10000) {
                System.out.println("Employees already seeded.");
                return;
            }

            for (int i = 1; i <= 10000; i++) {

                Employee employee = new Employee();

                employee.setEmployeeCode(String.format("EMP%05d", i));
                employee.setFirstName("FirstName" + i);
                employee.setLastName("LastName" + i);
                employee.setEmail("employee" + i + "@example.com");

                employee.setCountry(
                    i % 2 == 0 ? "India" : "USA"
                );

                employee.setDepartment(
                    i % 4 == 0 ? "Engineering" :
                    i % 4 == 1 ? "HR" :
                    i % 4 == 2 ? "Finance" :
                    "Sales"
                );

                employee.setJobTitle("Software Engineer");
                employee.setCreatedAt(java.time.LocalDateTime.now());
employee.setUpdatedAt(java.time.LocalDateTime.now());

                employeeRepository.save(employee);
            }

            System.out.println("10,000 employees seeded successfully.");
        };
    }
}