import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LessonService {
  private URL = 'http://localhost:3000/api/course/';
  constructor() { }
}
