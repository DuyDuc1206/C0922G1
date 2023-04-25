import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Course} from '../../model/course';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private URL = 'http://localhost:3000/api/course/';

  constructor(private http: HttpClient) {
  }

  getALlCourse(): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.URL}`);
  }
}
