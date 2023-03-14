import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ITodo} from '../model/itodo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private readonly API_URL = 'http://localhost:3000/todo';

  constructor(private http: HttpClient) {
  }

  getAllTodo(): Observable<ITodo[]> {
    return this.http.get<ITodo[]>(this.API_URL);
  }

  findById(id: number): Observable<ITodo> {
    return this.http.get<ITodo>(`${this.API_URL}/${id}`);
  }

  saveTodo(todo: ITodo): Observable<ITodo> {
    return this.http.post<ITodo>(this.API_URL, todo);
  }

  editTodo(id: number, Todo: ITodo): Observable<ITodo> {
    return this.http.put<ITodo>(`${this.API_URL}/${id}`, Todo);
  }

  deleteTodo(id: number): Observable<ITodo> {
    return this.http.delete<ITodo>(`${this.API_URL}/${id}`);
  }
}
