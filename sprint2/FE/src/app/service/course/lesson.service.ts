import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Lesson} from '../../model/lesson';

@Injectable({
  providedIn: 'root'
})
export class LessonService {
  private URL = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {
  }

  getAllLessonByCourseId(courseId: number): Observable<Lesson[]> {
    return this.http.get<Lesson[]>(`${this.URL}/course/${courseId}/lessons`);
  }

  getAll(): Observable<Lesson[]> {
    return this.http.get<Lesson[]>(`${this.URL}/lessons`);
  }

  getLessonById(lessonId: number): Observable<Lesson> {
    return this.http.get<Lesson>(`${this.URL}/lessons/${lessonId}`);
  }
}
