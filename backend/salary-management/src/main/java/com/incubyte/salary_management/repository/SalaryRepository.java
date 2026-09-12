package com.incubyte.salary_management.repository;

import com.incubyte.salary_management.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

    List<Salary> findByEmployeeId(Long employeeId);

    @Query("SELECT AVG(s.amount) FROM Salary s")
    BigDecimal findAverageAmount();

    @Query("SELECT MAX(s.amount) FROM Salary s")
    BigDecimal findHighestAmount();

    @Query("SELECT MIN(s.amount) FROM Salary s")
    BigDecimal findLowestAmount();
}