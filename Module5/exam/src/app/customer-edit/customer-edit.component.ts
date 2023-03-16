import {Component, OnInit} from '@angular/core';
import {CustomerTypeService} from "../service/customer-type.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../model/customer-type";
import {CustomerService} from "../service/customer.service";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerEditForm: FormGroup;
  customerTypeList: CustomerType[] = [];
  id: number;

  constructor(private customerTypeService: CustomerTypeService,
              private customerService: CustomerService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private toastr: ToastrService) {

  }

  ngOnInit(): void {
    this.getAllCustomerType();
    this.activatedRoute.paramMap.subscribe( paraMap => {
      this.id = +paraMap.get('id');
      this.getCustomer(this.id);
    })
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(item => {
      this.customerTypeList = item;
    })
  }

  getCustomer(id: number) {
    this.customerService.getCustomerById(id).subscribe(item => {
      this.customerEditForm = new FormGroup({
        id: new FormControl(item.id),
        name: new FormControl(item.name,[Validators.required, Validators.pattern('^([A-Z][a-z]+ )+[A-Z][a-z]+$'), Validators.minLength(6)]),
        birthday: new FormControl(item.birthday,[Validators.required]),
        gender: new FormControl(item.gender,[Validators.required]),
        import: new FormControl(item.import,[Validators.required]),
        export: new FormControl(item.export,[Validators.required]),
        phoneNumber: new FormControl(item.phoneNumber,[Validators.required, Validators.pattern('^\\+84\\d{8}$')]),
        email: new FormControl(item.email,[Validators.required, Validators.email]),
        customerType: new FormControl(this.customerTypeList.find(a=>a.id ===item.customerType.id),[Validators.required])
      })
    })
  }
  idControl = () => this.customerEditForm.get('id');
  nameControl = () => this.customerEditForm.get('name');
  birthdayControl = () => this.customerEditForm.get('birthday');
  genderControl = () => this.customerEditForm.get('gender');
  importControl = () => this.customerEditForm.get('import');
  exportControl = () => this.customerEditForm.get('export');
  phoneNumberControl = () => this.customerEditForm.get('phoneNumber');
  emailControl = () => this.customerEditForm.get('email');
  customerTypeControl = () => this.customerEditForm.get('customerType');

  onSubmit() {
    this.customerService.editCustomer(this.id,this.customerEditForm.value).subscribe( item =>{
    this.router.navigateByUrl('/customer');
    this.toastr.success("Edit Successfully!");
    })
  }
}
