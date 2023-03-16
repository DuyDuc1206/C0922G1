import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../service/customer.service";
import {CustomerTypeService} from "../service/customer-type.service";
import {Router} from "@angular/router";
import {CustomerType} from "../model/customer-type";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerTypeList: CustomerType[] = [];
  customerCreateForm: FormGroup;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
    this.customerCreateForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl('',[Validators.required, Validators.pattern('^([A-Z][a-z]+ )+[A-Z][a-z]+$'), Validators.minLength(6)]),
      birthday: new FormControl('',[Validators.required]),
      gender: new FormControl('',[Validators.required]),
      import: new FormControl('',[Validators.required]),
      export: new FormControl('',[Validators.required]),
      phoneNumber: new FormControl('',[Validators.required, Validators.pattern('^\\+84\\d{8}$')]),
      email: new FormControl('',[Validators.required, Validators.email]),
      customerType: new FormControl('',[Validators.required])
    })
  }
  idControl = () => this.customerCreateForm.get('id');
  nameControl = () => this.customerCreateForm.get('name');
  birthdayControl = () => this.customerCreateForm.get('birthday');
  genderControl = () => this.customerCreateForm.get('gender');
  importControl = () => this.customerCreateForm.get('import');
  exportControl = () => this.customerCreateForm.get('export');
  phoneNumberControl = () => this.customerCreateForm.get('phoneNumber');
  emailControl = () => this.customerCreateForm.get('email');
  customerTypeControl = () => this.customerCreateForm.get('customerType');

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(item => {
      this.customerTypeList = item;
    })
  }

  onSubmit() {
    debugger;
    this.customerService.createCustomer(this.customerCreateForm.value).subscribe( item => {
      this.router.navigateByUrl('/customer');
      this.toastr.success("Create Successfully!");
    })
  }
}
