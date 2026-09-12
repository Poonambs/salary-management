
import {
  Component,
  OnInit,
  ChangeDetectorRef
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employee-list.html',
  styleUrl: './employee-list.css'
})
export class EmployeeList implements OnInit {

  employees: any[] = [];
  filteredEmployees: any[] = [];
  salaries: any[] = [];

  selectedCountry: string = '';
  selectedDepartment: string = '';

  selectedEmployee: any = null;

  constructor(
    private http: HttpClient,
    private changeDetectorRef: ChangeDetectorRef
  ) {}

  ngOnInit(): void {

    this.http.get<any>(
      'http://localhost:8080/api/employees?page=0&size=20'
    )
    .subscribe(data => {

      console.log('EMPLOYEES:', data);

      this.employees = data.content;

      this.filteredEmployees = [...this.employees];

      this.employees.forEach(employee => {

        this.http.get<any[]>(
          `http://localhost:8080/api/salaries/employee/${employee.id}`
        )
        .subscribe(salaryData => {

          console.log(
            'SALARY FOR',
            employee.employeeCode,
            salaryData
          );

          if (salaryData.length > 0) {
            this.salaries.push(salaryData[0]);
          }

        });

      });

    });

  }

  getSalary(employeeId: number): string {

    const salary = this.salaries.find(
      salary => salary.employee?.id === employeeId
    );

    if (!salary) {
      return 'Not available';
    }

    return `${salary.currency} ${salary.amount}`;
  }

  viewEmployee(employee: any): void {

    console.log('VIEW CLICKED:', employee);

    this.selectedEmployee = employee;

    console.log(
      'SELECTED EMPLOYEE:',
      this.selectedEmployee
    );

    this.changeDetectorRef.detectChanges();
  }

  filterByCountry(event: Event): void {

    this.selectedCountry =
      (event.target as HTMLSelectElement).value;

    this.applyFilters();
  }

  filterByDepartment(event: Event): void {

    this.selectedDepartment =
      (event.target as HTMLSelectElement).value;

    this.applyFilters();
  }

  applyFilters(): void {

    this.filteredEmployees = this.employees.filter(employee => {

      const countryMatches =
        this.selectedCountry === '' ||
        employee.country === this.selectedCountry;

      const departmentMatches =
        this.selectedDepartment === '' ||
        employee.department === this.selectedDepartment;

      return countryMatches && departmentMatches;
    });

    this.changeDetectorRef.detectChanges();
  }

}
