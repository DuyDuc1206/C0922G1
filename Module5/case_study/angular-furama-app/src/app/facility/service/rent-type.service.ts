import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RentType} from '../model/rent-type';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RentTypeService {
  private URL = 'http://localhost:3000/rent-type';

  constructor(private http: HttpClient) {
  }

  getAllRentType(): Observable<RentType[]> {
    return this.http.get<RentType[]>(`${this.URL}`);
  }
}
