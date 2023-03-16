import {Injectable} from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private URL = 'http://localhost:3000/customers';

  constructor(private http: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.URL);
  }

  searchAll(nameSearch: string, emailSearch: string, customerTypeId: number): Observable<Customer[]> {
    return this.http.get<Customer[]>('http://localhost:3000/customers' + '?name_like=' + nameSearch + '&email_like=' +
      emailSearch + `&customerType.id=` + customerTypeId);
  }

  searchAllNotCustomerType(nameSearch: string, emailSearch: string): Observable<Customer[]> {
    return this.http.get<Customer[]>('http://localhost:3000/customers' + '?name_like=' + nameSearch + '&email_like=' + emailSearch);
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
