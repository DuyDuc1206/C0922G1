import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.email, Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  constructor() {
  }

  ngOnInit(): void {
  }


  get CheckEmail() {
    return this.loginForm.get('email');
  }

  get checkPassword() {
    return this.loginForm.get('password');
  }

  submit() {
    console.log(this.loginForm.value);
  }
}
