import {Injectable} from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private URL = 'http://localhost:3000/customer';

  constructor(private http: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.URL);
  }

  searchNameAndCustomerType(searchName: string, searchCustomerType: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.URL}?name_like=${searchName}&customer-type?name_like=${searchCustomerType}`);
  }

  createCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.URL, customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.URL}/${id}`);
  }

  editCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.URL}/${id}`, customer);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${this.URL}/${id}`);
  }
}
