import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../model/employee';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  constructor(private http: HttpClient) {
  }

  findAllEmployee(): Observable<Employee> {
    return this.http.get('http://localhost:3000/customer').pipe(map((response: any) => response));
  }
}
