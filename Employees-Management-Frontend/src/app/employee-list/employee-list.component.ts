import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  employees?: Employee[];
  firstName: any;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.getEmployees();
  }
  private getEmployees() {
    this.employeeService.getEmployeeList().subscribe((data) => {
      this.employees = data;
    });
  }
  Search() {
    if (this.firstName == '') {
      this.ngOnInit();
    } else {
      this.employees = this.employees?.filter((res) => {
        return res.firstName
          ?.toLocaleLowerCase()
          .match(this.firstName.toLocaleLowerCase());
      });
    }
  }

  /*
    this.employees = [
      {
        id: 1,
        firstName: 'mortadha',
        lastName: 'bouallagui',
        email: 'mortadha.bouallagui@esprit.tn',
      },
      {
        id: 2,
        firstName: 'mohamed',
        lastName: 'bouallagui',
        email: 'mohamed.bouallagui@esprit.tn',
      },
    ];*/
}
