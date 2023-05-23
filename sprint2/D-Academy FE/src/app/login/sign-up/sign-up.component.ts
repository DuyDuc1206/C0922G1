import {Component, Input, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {AuthService} from '../../service/auth.service';
import {Router} from '@angular/router';
import {SignUpForm} from '../../model/sign-up-form';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  status = 'Please fill in the form to register';
  form: any = {};
  hide = true;
  signUpForm: SignUpForm;
  isCheckSuccess = false;
  error1: any = {
    message: "nouser"
  }
  error2: any = {
    message: "noemail"
  }
  success: any = {
    message: "yes"
  }
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email
  ])
  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {

  }
  signUp(){
    this.signUpForm = new SignUpForm(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password
    )
    console.log('signUpForm === ',this.signUpForm)
    this.authService.signUp(this.signUpForm).subscribe(data =>{
      console.log('data == ', data)
      if(JSON.stringify(data)==JSON.stringify(this.error1)){
        this.status = 'The username is existed! Please try again!'
      }
      if(JSON.stringify(data)==JSON.stringify(this.error2)){
        this.status = 'The email is existed! Please try again!'
      }
      if(JSON.stringify(data)==JSON.stringify(this.success)){
        this.status = 'Create User account success -->'
        this.isCheckSuccess = true;
        // this.isSuccess = 'Create User account success! Please Login!'
        // this.router.navigate(['login']);
        // this.isCheck = true;
        // this.authService.setOption(this.isCheck);
        this.authService.setData(true);
        this.router.navigate(['login']);
      }
    })
  }

}
