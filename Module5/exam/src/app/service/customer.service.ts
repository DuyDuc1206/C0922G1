import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private URL = 'http://localhost:3000/customers';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.URL}`);
  }

  getCustomerById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.URL}/${id}`);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${this.URL}/${id}`);
  }

  createCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.URL, customer);
  }

  editCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.URL}/${id}`, customer);
  }

  searchNameAndEmail(nameSearch: string, emailSearch: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.URL + '?name_like=' + nameSearch + '&email_like=' + emailSearch);
  }
  searchAll(nameSearch: string, emailSearch: string, customerTypeId: number): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.URL + '?name_like=' + nameSearch + '&email_like=' + emailSearch + '&customerType.id=' + customerTypeId);
  }
}
