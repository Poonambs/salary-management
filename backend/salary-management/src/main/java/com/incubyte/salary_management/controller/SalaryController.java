package com.incubyte.salary_management.controller;

import com.incubyte.salary_management.entity.Salary;
import com.incubyte.salary_management.repository.SalaryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    private final SalaryRepository salaryRepository;

    public SalaryController(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

   @GetMapping("/employee/{employeeId}")
public List<Salary> getSalaryHistory(@PathVariable Long employeeId) {
    return salaryRepository.findByEmployeeId(employeeId);
}

    @GetMapping("/{id}")
    public Salary getSalaryById(@PathVariable Long id) {
        return salaryRepository.findById(id)
                .orElseThrow();
    }

    @PostMapping
    public Salary createSalary(@RequestBody Salary salary) {
        return salaryRepository.save(salary);
    }

    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Long id) {
        salaryRepository.deleteById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Salary controller is working";
    }
}