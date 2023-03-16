import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';
import {CustomerTypeService} from '../service/customer-type.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../model/customer-type';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerCreateForm: FormGroup;
  customerTypeList: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private router: Router,
              private customerTypeService: CustomerTypeService,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
    this.customerCreateForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl('', [Validators.required]),
      birthday: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required]),
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{8}$')]),
      address: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      customerType: new FormControl('', [Validators.required]),
    });
  }

  idControl = () => this.customerCreateForm.get('id');
  nameControl = () => this.customerCreateForm.get('name');
  birthdayControl = () => this.customerCreateForm.get('birthday');
  genderControl = () => this.customerCreateForm.get('gender');
  idCardControl = () => this.customerCreateForm.get('idCard');
  phoneNumberControl = () => this.customerCreateForm.get('phoneNumber');
  addressControl = () => this.customerCreateForm.get('address');
  emailControl = () => this.customerCreateForm.get('email');
  customerTypeControl = () => this.customerCreateForm.get('customerType');


  getAllCustomerType() {
    this.customerTypeService.getAllCustomerType().subscribe(customerType => {
      this.customerTypeList = customerType;
    });
  }

  onSubmit() {
    this.customerService.createCustomer(this.customerCreateForm.value).subscribe(customer => {
      this.router.navigateByUrl('/customer');
      this.toastr.success('Add Successfully');
    });
  }
}
