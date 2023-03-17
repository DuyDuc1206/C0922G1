import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Coach} from "../model/coach";

@Injectable({
  providedIn: 'root'
})
export class CoachService {
private URL = 'http://localhost:8080/coach';
  constructor(private http:HttpClient) { }
  // @ts-ignore
  getAll(): Observable<Coach[]>{
    return this.http.get<Coach[]>(this.URL);
  }
  deleteCoach(id: number): Observable<Coach>{
    return this.http.delete<Coach>(`${this.URL}/${id}`);
  }
  editCoach(id: number, coach: Coach): Observable<Coach>{
    return this.http.patch<Coach>(`${this.URL}/${id}`,coach);
  }
  getById(id: number): Observable<Coach>{
    return this.http.get<Coach>(`${this.URL}/${id}`);
  }
  create(coach: Coach): Observable<Coach>{
    return this.http.post<Coach>(this.URL,coach);
  }
}
