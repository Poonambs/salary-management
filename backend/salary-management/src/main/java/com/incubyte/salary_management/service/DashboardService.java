package com.incubyte.salary_management.service;

import com.incubyte.salary_management.dto.DashboardResponse;
import com.incubyte.salary_management.repository.EmployeeRepository;
import com.incubyte.salary_management.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DashboardService {

    private final EmployeeRepository employeeRepository;
    private final SalaryRepository salaryRepository;

    public DashboardService(
            EmployeeRepository employeeRepository,
            SalaryRepository salaryRepository) {

        this.employeeRepository = employeeRepository;
        this.salaryRepository = salaryRepository;
    }

    public DashboardResponse getDashboardData() {

        long totalEmployees = employeeRepository.count();

        BigDecimal averageSalary = salaryRepository.findAverageAmount();
        BigDecimal highestSalary = salaryRepository.findHighestAmount();
        BigDecimal lowestSalary = salaryRepository.findLowestAmount();

        return new DashboardResponse(
                totalEmployees,
                averageSalary,
                highestSalary,
                lowestSalary
        );
    }
}