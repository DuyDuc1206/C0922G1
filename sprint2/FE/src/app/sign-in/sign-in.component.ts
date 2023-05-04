import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {TokenService} from '../service/token.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../service/auth.service';
import {ShareService} from '../service/share.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  signInForm: FormGroup;
  isLogged = false;
  message = '';
  username: string;
  roles: string[] = [];

  constructor(private tokenService: TokenService,
              private authService: AuthService,
              private shareService: ShareService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.signInForm = new FormGroup({
      username: new FormControl(),
      password: new FormControl(),
      rememberMe: new FormControl(false)
    });
    this.isLogged = this.tokenService.isLogined();
    if (this.isLogged) {
      this.router.navigateByUrl('/');
    }
  }

  async login() {
    if (this.isLogged || this.tokenService.isLogined()) {
      return;
    }
    this.authService.signIn(this.signInForm.value).subscribe(next => {
        if (this.signInForm.value.rememberMe) {
          this.tokenService.rememberMe(next.token,next.id, next.name, next.roles, 'local');
        } else {
          this.tokenService.rememberMe(next.token,next.id, next.name, next.roles, 'session');
        }
        this.isLogged = true;
        this.signInForm.reset();
        this.shareService.sendClickEvent();
        this.router.navigateByUrl('/');
      }, error => {
        console.log(error);
        if (error.error) {
          for (let i = 0; i < error.error.length; i++) {
            this.message = error.error[i].defaultMessage;
          }
        }
        if (error.error.message) {
          this.message = error.error.message;
        }
      }
    );
  }
}
