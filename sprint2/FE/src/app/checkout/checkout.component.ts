import {Component, OnInit} from '@angular/core';
import {CartService} from '../service/cart/cart.service';
import {Cart} from '../model/cart';
import {TokenService} from '../service/token.service';
import {AuthService} from '../service/auth.service';
import {User} from '../model/user';
import {render} from 'creditcardpayments/creditCardPayments';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  carts: Cart[] = [];
  id: number = 0;
  user: User = {};
  total: number = 0;

  constructor(private cartService: CartService,
              private tokenService: TokenService,
              private authService: AuthService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.authService.profile(this.tokenService.getId()).subscribe(next => {
      this.user = next;
      this.id = this.user.id;
    });
    this.getAllCarts();
  }

  getAllCarts() {
    this.cartService.getCartByUser(this.id).subscribe(next => {
      this.carts = next;
      for (let i = 0; i < this.carts.length; i++) {
        this.total += this.carts[i].quantity * this.carts[i].course.price;
      }
      render({
        id: "#buttonPayment",
        currency: "USD",
        value: this.total.toFixed(),
        onApprove: (details) => {
          this.buy()
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Payment Success!',
            showConfirmButton: false,
            timer: 3000
          });
          this.getAll()
          this.router.navigateByUrl('/')
        }
      });
    });
  }
  buy() {
    const number = Math.floor(Math.random()*1000000000);
    const code ='DAcademy-' + number;

    // for (let i = 0; i < this.carts.length; i++) {
    //   this.orderService.order(this.address,
    //     this.carts[i].size * this.carts[i].quantity * this.carts[i].price, this.carts[i].id,
    //     this.carts[i].productId, this.carts[i].size, this.carts[i].quantity, code).subscribe(data => {
    //   })
    // }
    // this.cartService.setFlagDelete(this.user.id).subscribe()
  }
  getAll() {
    this.total = 0
    this.cartService.getCartByUser(this.user.id).subscribe(data => {
      this.carts = data
      // this.lenghtMessage.changeMassege(data.length);
      if (this.carts.length > 0) {
        for (let i = 0; i < this.carts.length; i++) {
          this.total += this.carts[i].quantity * this.carts[i].course.price;
        }
      }
    })
  }
}
