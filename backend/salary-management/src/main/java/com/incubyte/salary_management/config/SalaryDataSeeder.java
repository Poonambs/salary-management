package com.incubyte.salary_management.config;

import com.incubyte.salary_management.entity.Employee;
import com.incubyte.salary_management.entity.Salary;
import com.incubyte.salary_management.repository.EmployeeRepository;
import com.incubyte.salary_management.repository.SalaryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class SalaryDataSeeder {

    @Bean
    CommandLineRunner seedSalaries(
            EmployeeRepository employeeRepository,
            SalaryRepository salaryRepository) {

        return args -> {

            if (salaryRepository.count() >= 10000) {
                System.out.println("Salaries already seeded.");
                return;
            }

            for (Employee employee : employeeRepository.findAll()) {

                if (salaryRepository.findByEmployeeId(employee.getId()).isEmpty()) {

                    Salary salary = new Salary();

                    salary.setEmployee(employee);

                    salary.setAmount(
                            BigDecimal.valueOf(
                                    50000 + (employee.getId() % 10) * 5000
                            )
                    );

                    salary.setCurrency("INR");
                    salary.setEffectiveFrom(LocalDate.of(2026, 9, 1));

                    salary.setCreatedAt(
                            java.time.LocalDateTime.now()
                    );

                    salaryRepository.save(salary);
                }
            }

            System.out.println("Salary data seeded successfully.");
        };
    }
}