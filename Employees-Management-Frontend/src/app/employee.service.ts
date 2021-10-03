import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private baseUrl = 'http://localhost:8055/List';
  constructor(private HttpClient: HttpClient) {}

  getEmployeeList(): Observable<Employee[]> {
    return this.HttpClient.get<Employee[]>(`${this.baseUrl}`);
  }
}
