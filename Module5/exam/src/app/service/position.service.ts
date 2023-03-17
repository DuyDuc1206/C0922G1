import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Position} from "../model/position";

@Injectable({
  providedIn: 'root'
})
export class PositionService {
  private URL = 'http://localhost:8080/position';
  constructor(private http: HttpClient) { }
  getAll(): Observable<Position[]>{
    return this.http.get<Position[]>(this.URL);
  }
}
