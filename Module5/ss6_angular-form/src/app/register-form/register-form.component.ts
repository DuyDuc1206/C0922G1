import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
  countryList = [
    {id: 1, name: 'Viet Nam'},
    {id: 2, name: 'China'},
    {id: 3, name: 'America'},
  ];
  registerForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.minLength(6), Validators.required]),
    confirmPassword: new FormControl('', [Validators.required]),
    country: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.required, Validators.min(18)]),
    gender: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.pattern('^\\+84\\d{9,10}$')]),
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.registerForm.value);
  }
}
