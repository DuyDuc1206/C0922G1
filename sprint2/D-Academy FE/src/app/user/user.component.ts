import { Component, OnInit } from '@angular/core';
import {User} from '../model/user';
import {FormControl, FormGroup} from '@angular/forms';
import {TokenService} from '../service/token.service';
import {CartService} from '../service/cart/cart.service';
import {Title} from '@angular/platform-browser';
import {OrderService} from '../service/cart/order.service';
import {Purchase} from '../model/purchase';
import {OrderDTO} from '../model/order-dto';
import {AuthService} from '../service/auth.service';
import {Orders} from '../model/orders';
import {ICart} from '../model/i-cart';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  profile = true;
  purchase = false;
  changePass = false;

  orderList: Orders[] = []
  detailList: Purchase[] = []

  user: User = {};
  formUpdate: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    avatar: new FormControl(),
    userName: new FormControl(),
    password: new FormControl(),
    phoneNumber: new FormControl(),
    email: new FormControl(),
    address: new FormControl(),
    dateOfBirth: new FormControl(),
    gender: new FormControl(),
  });

  constructor(private tokenService: TokenService,
              private orderService: OrderService,
              private authService: AuthService,
              private title: Title) {
    this.authService.profile(this.tokenService.getId()).subscribe(data=>{
      this.user = data
      this.formUpdate.patchValue(this.user);

    })
    this.orderService.purchaseHistories(this.tokenService.getId()).subscribe(data=>{
      this.orderList = data
    })
  }

  ngOnInit(): void {
    window.scrollTo(1900, 600)
    this.title.setTitle('Personal information')
  }


  getProfile() {
    this.profile = true;
    this.purchase = false;
    this.changePass = false;
  }

  purchaseHistory() {
    this.profile = false;
    this.purchase = true;
    this.changePass = false;
  }

  changePassword() {

  }

  detailPurchase(codeOrder: any) {
    this.orderService.detailPurchase(codeOrder).subscribe(data=>{
      this.detailList = data;
    })
  }

  edit() {

  }
}
