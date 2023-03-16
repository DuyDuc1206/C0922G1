import {Component, OnInit} from '@angular/core';
import {CustomerType} from "../model/customer-type";
import {CustomerService} from "../service/customer.service";
import {CustomerTypeService} from "../service/customer-type.service";
import {Customer} from "../model/customer";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerList: Customer[] = [];
  customerTypeList: CustomerType[] = [];
  removeCustomer: Customer = {};
  p: number = 1;
  nameSearch: string = '';
  emailSearch: string = '';
  customerTypeSearch: number = 0;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllCustomer();
    this.getAllCustomerType();
  }

  getAllCustomer() {
    this.customerService.getAll().subscribe(item => {
      this.customerList = item;
    })
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(item => {
      this.customerTypeList = item;
    })
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.removeCustomer.id).subscribe(item => {
      this.getAllCustomer();
      this.toastr.success("Delete Successfully!");
    })
  }

  searchCustomer() {
    if (this.customerTypeSearch) {
      this.customerService.searchAll(this.nameSearch, this.emailSearch, this.customerTypeSearch).subscribe(data => {
        this.customerList = data;
        this.p = 1;
      })
    } else {
      this.customerService.searchNameAndEmail(this.nameSearch, this.emailSearch).subscribe(data => {
        this.customerList = data;
        this.p = 1;
      })
    }
  }
}
