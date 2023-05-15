import {Injectable} from '@angular/core';
import {Facility} from '../model/facility';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  private URL = 'http://localhost:3000/facility';

  constructor(private http: HttpClient) {
  }

  findAllFacility(): Observable<Facility[]> {
    return this.http.get<Facility[]>(`${this.URL}`);
  }

  findByIdFacility(id: number): Observable<Facility> {
    return this.http.get<Facility>(`${this.URL}/${id}`);
  }

  createFacility(facility: Facility): Observable<Facility> {
    return this.http.post<Facility>(`${this.URL}`, facility);
  }

  updateFacility(id: number, facility: Facility): Observable<Facility> {
    return this.http.put<Facility>(`${this.URL}/${id}`, facility);
  }
}
