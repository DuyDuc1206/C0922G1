import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Orders} from '../../model/orders';
import {Purchase} from '../../model/purchase';
import {OrderDTO} from '../../model/order-dto';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private URL = 'http://localhost:8080/api/orders';
  constructor(private http: HttpClient) { }
  order(totalPrice: any, idCart: any,idCourse: any, codeOrder: any){
    return this.http.post<OrderDTO>(`${this.URL}/add`, {totalPrice: totalPrice, idCart: idCart, idCourse: idCourse, codeOder: codeOrder})
  }

  purchaseHistories(idUser: any){
    return this.http.get<Orders[]>(`${this.URL}/list?idUser=${idUser}` )
  }

  detailPurchase(codeOrder: any){
    return this.http.get<Purchase[]>(`${this.URL}/detail-purchase?codeOrder=${codeOrder}`)
  }
}
