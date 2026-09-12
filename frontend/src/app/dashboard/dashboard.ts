
import {
  Component,
  OnInit,
  ChangeDetectorRef
} from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [DecimalPipe],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent implements OnInit {

  totalEmployees: number = 0;
  averageSalary: number = 0;
  highestSalary: number = 0;
  lowestSalary: number = 0;

  constructor(
    private http: HttpClient,
    private changeDetectorRef: ChangeDetectorRef
  ) {}

  ngOnInit(): void {

    this.http.get<any>('http://localhost:8080/api/dashboard')
      .subscribe({
        next: (data) => {

          console.log('DASHBOARD DATA:', data);

          this.totalEmployees = Number(data.totalEmployees);
          this.averageSalary = Number(data.averageSalary);
          this.highestSalary = Number(data.highestSalary);
          this.lowestSalary = Number(data.lowestSalary);

          this.changeDetectorRef.detectChanges();

          console.log('TOTAL:', this.totalEmployees);
          console.log('AVERAGE:', this.averageSalary);
          console.log('HIGHEST:', this.highestSalary);
          console.log('LOWEST:', this.lowestSalary);
        },

        error: (error) => {
          console.error('DASHBOARD ERROR:', error);
        }
      });

  }
}

