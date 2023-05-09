import {Component, OnInit} from '@angular/core';
import {CartService} from '../../service/cart/cart.service';
import {Cart} from '../../model/cart';
import {TokenService} from '../../service/token.service';
import {AuthService} from '../../service/auth.service';
import {User} from '../../model/user';
import {render} from 'creditcardpayments/creditCardPayments';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';
import {OrderService} from '../../service/cart/order.service';
import {ShareService} from '../../service/share.service';
import {ICart} from '../../model/i-cart';
import {OrderDTO} from '../../model/order-dto';

declare let paypal: any;

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  carts: ICart[] = [];
  orderDto: OrderDTO = {};
  id: number = 0;
  user: User = {};
  total: number = 0;

  constructor(private cartService: CartService,
              private orderService: OrderService,
              private tokenService: TokenService,
              private authService: AuthService,
              private router: Router,
              private shareService: ShareService) {
  }

  async ngOnInit() {
    await this.getUser();
    this.getAllCarts();
  }

  async getUser() {
    const user = await this.authService.profile(this.tokenService.getId()).toPromise();
    this.user = user;
    this.id = this.user.id;
  }

  getAllCarts() {
    this.cartService.getCartByUser(this.user.id).subscribe(next => {
      this.carts = next;
      for (let i = 0; i < this.carts.length; i++) {
        this.total += this.carts[i].quantity * this.carts[i].price;
      }
      render({
        id: '#buttonPayment',
        currency: 'USD',
        value: this.total.toFixed(2),
        onApprove: (details) => {
          this.buy();
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Payment Success!',
            showConfirmButton: false,
            timer: 3000
          });
          this.getAll();
          this.router.navigateByUrl('/');
        }
      });
    });
  }

  buy() {
    // // Lấy giá trị của biến orderCount từ localStorage
    // let orderCount = parseInt(localStorage.getItem('orderCount') || '0');
    // orderCount++;

    this.shareService.incrementOrderCount();
    const codeOrder = 'DAcademy-' + this.shareService.getOrderCount().toString().padStart(4,'0');

    for (let i = 0; i < this.carts.length; i++) {
      this.orderService.order(
        this.carts[i].quantity * this.carts[i].price, this.carts[i].id,
        this.carts[i].idCourse, codeOrder).subscribe(data => {
          this.orderDto = data;
      });
    }
    this.cartService.setFlagDelete(this.user.id).subscribe();
    // // Lưu giá trị của biến orderCount vào localStorage
    // localStorage.setItem('orderCount', orderCount.toString());
  }

  getAll() {
    this.total = 0;
    this.cartService.getCartByUser(this.user.id).subscribe(data => {
      this.carts = data;
      if (this.carts.length > 0) {
        for (let i = 0; i < this.carts.length; i++) {
          this.total += this.carts[i].quantity * this.carts[i].price;
        }
      }
    });
  }


}
