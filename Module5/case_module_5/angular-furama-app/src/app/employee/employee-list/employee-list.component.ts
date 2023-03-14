import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../service/employee.service';

class Employee {
}

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    // this.employees = this.employeeService.findAllEmployee();
  }

}
