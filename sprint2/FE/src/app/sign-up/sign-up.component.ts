import {Component, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {AuthService} from '../service/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signUpForm: FormControl;
  error1: any = {
    message: 'no_user'
  };
  error2: any = {
    message: 'no_email'
  };
  success: any = {
    message: 'yes'
  };
  status = 'Please fill in the form to Register!';

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    this.signUpForm = new FormControl({
      username: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      confirmPassword: new FormControl('', Validators.required),
    });
  }

  signUp() {
    this.authService.signUp(this.signUpForm).subscribe(data => {
      if (JSON.stringify(data) === JSON.stringify(this.error1)) {
        this.status = 'The username is existed! Please try!';
      }
      if (JSON.stringify(data) === JSON.stringify(this.error2)) {
        this.status = 'The email is existed! Please try!';
      }
      if (JSON.stringify(data) === JSON.stringify(this.success)) {
        this.status = 'Create account success!';
      }
    });
    console.log('false');
  }

}
