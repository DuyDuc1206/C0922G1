import {Injectable} from '@angular/core';
import {Contract} from '../model/contract';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  contractList: Contract[] = [
    {
      id: 1,
      startDate: '2020-12-08',
      endDate: '2020-12-08',
      deposit: 0,
    }
  ];

  constructor(private ) {
  }
}
