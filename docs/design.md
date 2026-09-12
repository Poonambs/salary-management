# Salary Management System - Design

## Goal

Provide HR managers with a simple web application to view employee and salary information for an organization with approximately 10,000 employees.

## Main Features

### Dashboard

The dashboard provides:

- Total employee count
- Average salary
- Highest salary
- Lowest salary

### Employee Management

HR users can:

- View employees
- View employee details
- View current salary
- Filter employees by country
- Filter employees by department
- Combine country and department filters

### Salary Management

Salary information is associated with employees.

Each salary record contains:

- Employee
- Amount
- Currency
- Effective date

## API Design

### Employee APIs

`GET /api/employees`

Returns a paginated list of employees.

`GET /api/employees/{id}`

Returns a specific employee.

`GET /api/employees/count`

Returns the total number of employees.

### Salary API

`GET /api/salaries/employee/{employeeId}`

Returns salary information for an employee.

### Dashboard API

`GET /api/dashboard`

Returns dashboard salary statistics.

## Pagination

Employee data is returned using pagination.

The initial frontend request loads 20 employees instead of loading all 10,000 employees at once.

## Filtering

The frontend currently applies country and department filters to the loaded employee page.

For a production-scale implementation, these filters can be moved to the backend so filtering happens directly in PostgreSQL.

## Data Model

An employee can have one or more salary records.

```text
Employee
   |
   | 1 : many
   v
Salary