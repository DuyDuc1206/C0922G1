import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../model/customer-type';
import {CustomerService} from '../service/customer.service';
import {CustomerTypeService} from '../service/customer-type.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerEditForm: FormGroup;
  customerTypeList: CustomerType[] = [];
  id: number;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
      this.getCustomer(this.id);
    });
  }

  onSubmit() {
    this.customerService.editProduct(this.id, this.customerEditForm.value).subscribe(item => {
      this.router.navigateByUrl('/customer');
    });

  }

  getCustomer(id: number) {
    this.customerService.findById(id).subscribe(item => {
      this.customerEditForm = new FormGroup({
        id: new FormControl(),
        name: new FormControl(item.name, [Validators.required]),
        birthday: new FormControl(item.birthday, [Validators.required]),
        gender: new FormControl(item.gender, [Validators.required]),
        idCard: new FormControl(item.idCard, [Validators.required]),
        phoneNumber: new FormControl(item.phoneNumber, [Validators.required]),
        address: new FormControl(item.address, [Validators.required]),
        email: new FormControl(item.email, [Validators.required]),
        customerType: new FormControl(item.customerType, [Validators.required]),
      });
    });
  }
  idControl = () => this.customerEditForm.get('id');
  nameControl = () => this.customerEditForm.get('name');
  birthdayControl = () => this.customerEditForm.get('birthday');
  genderControl = () => this.customerEditForm.get('gender');
  idCardControl = () => this.customerEditForm.get('idCard');
  phoneNumberControl = () => this.customerEditForm.get('phoneNumber');
  addressControl = () => this.customerEditForm.get('address');
  emailControl = () => this.customerEditForm.get('email');
  customerTypeControl = () => this.customerEditForm.get('customerType');

  getAllCustomerType() {
    this.customerTypeService.getAllCustomerType().subscribe(customerTypeList => {
      this.customerTypeList = customerTypeList;
    });
  }
}
