package com.incubyte.salary_management.dto;

import java.math.BigDecimal;

public class DashboardResponse {

    private long totalEmployees;
    private BigDecimal averageSalary;
    private BigDecimal highestSalary;
    private BigDecimal lowestSalary;

    public DashboardResponse(
            long totalEmployees,
            BigDecimal averageSalary,
            BigDecimal highestSalary,
            BigDecimal lowestSalary) {

        this.totalEmployees = totalEmployees;
        this.averageSalary = averageSalary;
        this.highestSalary = highestSalary;
        this.lowestSalary = lowestSalary;
    }

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public BigDecimal getHighestSalary() {
        return highestSalary;
    }

    public BigDecimal getLowestSalary() {
        return lowestSalary;
    }
}