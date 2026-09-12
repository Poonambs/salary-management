import { Component } from '@angular/core';
import { EmployeeList } from './employee-list/employee-list';
import { DashboardComponent } from './dashboard/dashboard';

@Component({
  selector: 'app-root',
  imports: [EmployeeList, DashboardComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {}