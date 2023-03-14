import {Component, OnInit} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';
import {CustomerTypeService} from '../service/customer-type.service';
import {CustomerType} from '../model/customer-type';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  customerTypeList: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService) {
  }

  ngOnInit(): void {
    this.getAllCustomer();
    this.getAllCustomerType();
  }

  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(customer => {
      this.customerList = customer;
    });
  }

  getAllCustomerType() {
    this.customerTypeService.getAllCustomerType().subscribe(customerType => {
      this.customerTypeList = customerType;
    });
  }

}
