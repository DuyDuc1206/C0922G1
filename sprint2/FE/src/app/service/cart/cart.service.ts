import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Course} from '../../model/course';
import {User} from '../../model/user';
import {Cart} from '../../model/cart';
import {ICart} from '../../model/i-cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private URL = 'http://localhost:8080/api/cart';

  constructor(private http: HttpClient) {
  }
  putQuantity(id_user: number, id:number,quantity:string): Observable<any> {
    let putDto = {
      id: id,
      idUser: id_user,
      quantity:quantity,
    }
    return this.http.post<any>('http://localhost:8080/api/cart/buyDetail',putDto)
  }

  addToCart(course: Course, user: User): Observable<any> {
    let cart: Cart = {
      id: null, user: user, course: course, quantity: 1
    };
    return this.http.post<any>(`${this.URL}/add`, cart);
  }

  deleteCart(id: number): Observable<any> {
    return this.http.get<any>(`${this.URL}/delete/${id}`);
  }

  // getCartByUser(id: number): Observable<Cart[]> {
  //   return this.http.get<Cart[]>(`${this.URL}/${id}`);
  // }

  getCartByUser(id: number): Observable<ICart[]> {
    return this.http.get<ICart[]>(`${this.URL}/${id}`);
  }

  changeQuantity(operator:string,id:number): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/cart/change/'+operator + '/' +id)
  }

  setFlagDelete(idUser: any): Observable<Cart>{
    return this.http.get(`${this.URL}/flag-delete?idUser=${idUser}`)
  }
}
