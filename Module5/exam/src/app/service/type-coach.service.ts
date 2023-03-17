import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TypeCoach} from "../model/type-coach";

@Injectable({
  providedIn: 'root'
})
export class TypeCoachService {
  private URL = 'http://localhost:8080/type-coach';
  constructor(private http: HttpClient) { }
  getAll():Observable<TypeCoach[]>{
    return this.http.get<TypeCoach[]>(this.URL);
  }
}
