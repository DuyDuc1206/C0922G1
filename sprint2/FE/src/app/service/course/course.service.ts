import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Course} from '../../model/course';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private URL = 'http://localhost:8080/api/course';

  constructor(private http: HttpClient) {
  }

  getALlCourse(nameSearch: string, page: number, size: number): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.URL}?nameSearch=${nameSearch}&page=${page}&size=${size}`);
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.URL}/${id}`);
  }

}
