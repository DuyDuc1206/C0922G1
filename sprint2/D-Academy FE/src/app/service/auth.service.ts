import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SignUpForm} from '../model/sign-up-form';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private API_SIGNIN = 'http://localhost:8080/api/auth/sign-in';
  private API_SIGNUP = 'http://localhost:8080/api/auth/sign-up';

  constructor(private http: HttpClient) {
  }

  signIn(obj): Observable<any> {
    return this.http.post(`${this.API_SIGNIN}`, {username: obj.username, password: obj.password});
  }

  signUp(signUp: SignUpForm): Observable<any> {
    return this.http.post(`${this.API_SIGNUP}`, signUp);
  }

  profile(id):Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/auth/profile/'+id);
  }

  public data: boolean;
  setData(data: boolean){
    this.data = data;
  }
  getData(){
    return this.data;
  }
}
