import {Injectable} from '@angular/core';
import {Contract} from '../model/contract';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  private URL = 'http://localhost:3000/contract';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Contract[]> {
    return this.http.get<Contract[]>(`${this.URL}`);
  }

  createContract(contract: Contract): Observable<Contract> {
    return this.http.post<Contract>(`${this.URL}`, contract);
  }
}
