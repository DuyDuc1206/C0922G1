import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerTypeService} from '../service/customer-type.service';
import {CustomerType} from '../model/customer-type';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  customerTypeList: CustomerType[] = [];
  id: number;
  customerDeleteForm: FormGroup;

  constructor(private customerService: CustomerService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private customerTypeService: CustomerTypeService) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
    });
  }

  getAllCustomerType() {
    this.customerTypeService.getAllCustomerType().subscribe(item => {
      this.customerTypeList = item;
      this.findCustomerById(this.id);
    });
  }

  findCustomerById(id: number) {
    return this.customerService.findById(id).subscribe(item => {
      this.customerDeleteForm = new FormGroup({
        name: new FormControl(item.name),
        birthday: new FormControl(item.birthday),
        gender: new FormControl(item.gender),
        idCard: new FormControl(item.idCard),
        phoneNumber: new FormControl(item.phoneNumber),
        address: new FormControl(item.address),
        email: new FormControl(item.email),
        customerType: new FormControl(item.customerType),
      });
    });
  }

  onSubmit() {
    this.customerService.deleteCustomer(this.id).subscribe(next => {
      this.router.navigateByUrl('/customer');
    });
  }
}
