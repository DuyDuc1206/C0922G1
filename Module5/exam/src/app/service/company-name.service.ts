import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanyName} from "../model/company-name";

@Injectable({
  providedIn: 'root'
})
export class CompanyNameService {
  private URL = 'http://localhost:8080/company-name';
  constructor(private http: HttpClient) { }
  getAll(): Observable<CompanyName[]>{
    return this.http.get<CompanyName[]>(this.URL);
  }
}
