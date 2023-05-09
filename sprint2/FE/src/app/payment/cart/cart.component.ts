import {Component, OnInit} from '@angular/core';
import {Cart} from '../../model/cart';
import {Course} from '../../model/course';
import {User} from '../../model/user';
import {TokenService} from '../../service/token.service';
import {ShareService} from '../../service/share.service';
import {Title} from '@angular/platform-browser';
import {CartService} from '../../service/cart/cart.service';
import {Router} from '@angular/router';
import {CourseService} from '../../service/course/course.service';
import {AuthService} from '../../service/auth.service';
import {ICart} from '../../model/i-cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  carts: ICart[] = [];
  courses: Course[] = [];
  total = 0;
  user: User;
  isLogged = false;
  quantity = 0;

  constructor(private tokenService: TokenService,
              private shareService: ShareService,
              private title: Title,
              private cartService: CartService,
              private router: Router,
              private authService: AuthService,
              private courseService: CourseService) {
  }

  ngOnInit(): void {
    this.isLogged = this.tokenService.isLogined();
    this.check();
    this.shareService.getClickEvent().subscribe(next => {
      this.isLogged = this.tokenService.isLogined();
      this.check();
    });
  }

  check() {
    if (this.isLogged) {
      this.authService.profile(this.tokenService.getId()).subscribe(next => {
          this.user = next;
          console.log('aa ' + this.user.id);
          this.cartService.getCartByUser(this.user.id).subscribe(next => {
              this.carts = next;
              this.getAllValue();
            }
          );
        }
      );
    } else {
      this.carts = this.tokenService.getCartSession();
      this.shareService.getClickEvent().subscribe(next => {
        this.carts = this.tokenService.getCartSession();
        this.getAllValue();
      });
      this.getAllValue();
    }
  }

  getAllValue() {
    this.quantity = 0;
    this.total = 0;
    if (this.carts != null) {
      for (let i = 0; i < this.carts.length; i++) {
        this.quantity += this.carts[i].quantity;
        this.total += this.carts[i].price * this.carts[i].quantity;
      }
    }
  }

  // getAll() {
  //   this.cartService.getCartByUsers(this.user.id).subscribe(next => {
  //       this.carts = next;
  //       this.getAllValue();
  //     }
  //   );
  //   this.shareService.getClickEvent().subscribe(next => {
  //       this.cartService.getCartByUsers(this.user.id).subscribe(next => {
  //           this.carts = next;
  //           this.getAllValue();
  //         }
  //       );
  //     }
  //   );
  // }

  changeQuantity(operator: string, id: number, index: number) {
    if (this.isLogged) {
      this.cartService.changeQuantity(operator, id).subscribe(next => {
        this.shareService.sendClickEvent();
        this.cartService.getCartByUser(this.user.id).subscribe(next => {
            this.carts = next;
            this.getAllValue();
          }
        );
      });
    } else {
      this.tokenService.changeQuantitySession(operator, index);
      this.shareService.sendClickEvent();
    }
  }

  deleteCart(id: number, index: number) {
    if (this.isLogged) {
      this.cartService.deleteCart(id).subscribe(next => {
        this.shareService.sendClickEvent();
        this.shareService.getClickEvent().subscribe(next => {
          this.cartService.getCartByUser(this.user.id).subscribe(next => {
              this.carts = next;
              this.getAllValue();
            }
          );
        });
      });
    } else {
      this.tokenService.deleteCartSessionIndex(index);
      this.shareService.sendClickEvent();
    }
  }

}
