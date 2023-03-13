import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  countryList = [
    {id: 1, country: 'Viet Nam'},
    {id: 2, country: 'China'},
    {id: 3, country: 'Korea'},
    {id: 4, country: 'Japan'},
  ];

  constructor() {
  }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.minLength(6), Validators.required]),
      confirmPassword: new FormControl('', [Validators.required, this.confirmPasswordValidator.bind(this)]),
      country: new FormControl('', [Validators.required]),
      dateImport: new FormControl('', [Validators.required, this.dateImportValidator.bind(this)]),
      dateExport: new FormControl('', [Validators.required, this.dateExportValidator.bind(this)]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      address: new FormGroup({
        city: new FormControl('', [Validators.required]),
        street: new FormControl('', [Validators.required]),
        pinCode: new FormControl('', [Validators.required])
      })
    });
  }

  get emailControl() {
    return this.registerForm.get('email');
  }

  passwordControl = () => this.registerForm.get('password');
  confirmPasswordControl = () => this.registerForm.get('confirmPassword');
  countryControl = () => this.registerForm.get('country');
  dateImportControl = () => this.registerForm.get('dateImport');
  dateExportControl = () => this.registerForm.get('dateExport');
  ageControl = () => this.registerForm.get('age');
  genderControl = () => this.registerForm.get('gender');
  phoneControl = () => this.registerForm.get('phone');
  addressGroup = () => this.registerForm.get('address');
  cityControl = () => this.registerForm.get('address').get('city');
  streetControl = () => this.registerForm.get('address').get('street');
  pinCodeControl = () => this.registerForm.get('address').get('pinCode');

  confirmPasswordValidator() {
    if (this.registerForm) {
      return this.confirmPasswordControl().value !== this.passwordControl().value ? {invalidConfirmPassword: true} : null;
    }
  }

  dateImportValidator() {
    if (this.registerForm) {
      const date = new Date(this.dateImportControl().value);
      const currentDate = new Date();
      const minDate = new Date('01-01-2000');
      return date > currentDate || date < minDate ? {invalidDateImport: true} : null;
    }
  }

  dateExportValidator() {
    if (this.registerForm) {
      const date = new Date(this.dateExportControl().value);
      const minDate = new Date(this.dateImportControl().value);
      const currentDate = new Date();
      return date > currentDate || date < minDate ? {invalidDateExport: true} : null;
    }
  }

  submit() {
    console.log(this.registerForm.value);
  }
}
