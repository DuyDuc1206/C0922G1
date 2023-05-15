import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FacilityType} from '../model/facility-type';

@Injectable({
  providedIn: 'root'
})
export class FacilityTypeService {
  private URL = 'http://localhost:3000/facility-type';

  constructor(private http: HttpClient) {
  }

  getAllFacilityType(): Observable<FacilityType[]> {
    return this.http.get<FacilityType[]>(`${this.URL}`);
  }
}
