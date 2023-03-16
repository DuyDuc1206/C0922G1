import {Component, OnInit} from '@angular/core';
import {Customer} from '../model/customer';
import {CustomerService} from '../service/customer.service';
import {CustomerTypeService} from '../service/customer-type.service';
import {CustomerType} from '../model/customer-type';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  customerTypeList: CustomerType[] = [];
  customerDelete: Customer = {};
  page = 1; // bắt đầu bằng 1
  nameSearch = '';
  emailSearch = '';
  customerTypeId = 0;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private toastr: ToastrService) {
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

  removeCustomer() {
    this.customerService.deleteCustomer(this.customerDelete.id).subscribe(item => {
      this.toastr.success('Delete Successfully');
      this.getAllCustomer();
    });
  }

  searchAll() {
    if (this.customerTypeId) {
      this.customerService.searchAll(this.nameSearch, this.emailSearch, this.customerTypeId).subscribe(data => {
        this.customerList = data;
        this.page = 1; // quay lại trang 1
      });
    } else {
      this.customerService.searchAllNotCustomerType(this.nameSearch, this.emailSearch).subscribe(data => {
        this.customerList = data;
        this.page = 1; // quay lại trang 1
      });
    }
  }
}

