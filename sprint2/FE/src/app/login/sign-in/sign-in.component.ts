import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {TokenService} from '../../service/token.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../../service/auth.service';
import {ShareService} from '../../service/share.service';
import Swal from 'sweetalert2';
import {Cart} from '../../model/cart';

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
  cart:Cart[] = []

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

    this.loadCart()
    this.shareService.getClickEvent().subscribe(next => {
      this.loadCart()
    })
    this.isLogged = this.tokenService.isLogined();
    console.log('aa ' + this.isLogged);
    if (this.isLogged) {
      this.router.navigateByUrl('/');
    }
  }
  loadCart() {
    this.isLogged = this.tokenService.isLogined();
    this.cart = this.tokenService.getCartSession();
  }
  async login() {
    if (this.isLogged || this.tokenService.isLogined()) {
      return;
    }
    this.authService.signIn(this.signInForm?.value).subscribe(next => {
        if (this.signInForm.controls.rememberMe.value) {
          this.tokenService.rememberMe(next.token,next.id, next.name, next.roles, 'local');
          console.log('b '+ this.isLogged);
        } else {
          this.tokenService.rememberMe(next.token,next.id, next.name, next.roles, 'session');
          console.log('c' + this.isLogged);
        }
        this.isLogged = true;
        console.log(this.isLogged);
      // Toast.fire({
      //   iconHtml: '<img style="width: 90px;height: 90px;padding: 10px;border-radius: 50%" src="'+next.avatar+'">',
      //   title: 'Chào mừng ' + next.name + ' đã quay trở lại!'
      // })
      //   this.signInForm.reset();
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
