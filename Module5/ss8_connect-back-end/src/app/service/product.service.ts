import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL = 'http://localhost:3000/products';

  constructor(private http: HttpClient) {
  }

  getAllProduct(): Observable<Product[]> {
    return this.http.get<Product[]>(this.URL);
  }

  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.URL, product);
  }
}
