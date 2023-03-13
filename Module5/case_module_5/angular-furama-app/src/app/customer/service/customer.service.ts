import {Injectable} from '@angular/core';
import {CustomerType} from '../model/customer-type';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customerList: Customer[] = [
    {
      id: 1,
      name: 'Nguyễn Thị Hào',
      dateOfBirth: '1970-11-07',
      gender: 'Nữ',
      idCard: '643431213',
      phoneNumber: '0945423362',
      address: '23 Nguyễn Hoàng, Đà Nẵng',
      email: 'thihao07@gmail.com',
    }
  ];

  constructor() {
  }

  findAll(): Customer[] {
    return this.customerList;
  }
}
