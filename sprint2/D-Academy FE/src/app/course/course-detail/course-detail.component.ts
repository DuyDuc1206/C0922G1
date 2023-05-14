import {Component, OnInit} from '@angular/core';
import {CourseService} from '../../service/course/course.service';
import {Course} from '../../model/course';
import {ActivatedRoute, Router} from '@angular/router';
import {Lesson} from '../../model/lesson';
import {LessonService} from '../../service/course/lesson.service';
import {CartService} from '../../service/cart/cart.service';
import {ShareService} from '../../service/share.service';
import Swal from 'sweetalert2';
import {TokenService} from '../../service/token.service';
import {User} from '../../model/user';
import {Cart} from '../../model/cart';
import {AuthService} from '../../service/auth.service';
import {ICart} from '../../model/i-cart';
import {OrderService} from '../../service/cart/order.service';
import {Purchase} from '../../model/purchase';
import {Orders} from '../../model/orders';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-course-detail',
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css']
})
export class CourseDetailComponent implements OnInit {
  course: Course = {};
  lessons: Lesson[] = [];
  courses: Course[] = [];
  id: number;
  nameSearch = '';
  page = 0;
  size = 4;
  isLogged = false;
  user: User;
  carts: ICart[] = [];
  cart: ICart = {};
  quantity = 0;
  total = 0;
  purchase: Purchase = {};
  orderList: Orders[] = [];
  isPurchaseAvailable: boolean = false;
  endDate: string ='';

  constructor(private courseService: CourseService,
              private lessonService: LessonService,
              private cartService: CartService,
              private shareService: ShareService,
              private tokenService: TokenService,
              private router: Router,
              private authService: AuthService,
              private activatedRoute: ActivatedRoute,
              private orderService: OrderService,
              private title: Title) {
    this.isLogged = this.tokenService.isLogined();
    this.shareService.sendClickEvent();
    this.shareService.getClickEvent().subscribe(next => {
      this.isLogged = this.tokenService.isLogined();
      this.check();
    });
    this.orderService.purchaseHistories(this.tokenService.getId()).subscribe(data => {
      this.orderList = data;
    });
  }

  ngOnInit(): void {
    this.title.setTitle('D Academy-Course detail')
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
      this.getCourse(this.id);
      this.getAllLessons(this.id);
    });
    this.getAllCourse(this.nameSearch, this.page, this.size);
    this.getDate();
    console.log('asdasd course ' + this.purchase.orderDate);
  }

  getCourse(id: number) {
    this.courseService.getCourseById(id).subscribe(data => {
      this.course = data;
    });
  }

  getAllLessons(id: number) {
    this.lessonService.getAllLessonByCourseId(id).subscribe(data => {
      this.lessons = data;
    });
  }

  getAllCourse(nameSearch: string, page: number, size: number) {
    this.courseService.getALlCourse(nameSearch, page, size).subscribe(data => {
      this.courses = data['content'].filter(course => course.idCourse !== this.course.idCourse);
    });
  }

  check() {
    if (this.isLogged) {
      this.authService.profile(this.tokenService.getId()).subscribe(next => {
          this.user = next;
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

  addToCart() {
    if (this.isLogged) {
      this.cartService.addToCart(this.course, this.user).subscribe(next => {
        this.shareService.sendClickEvent();
        this.cartService.getCartByUser(this.user.id).subscribe(next => {
          this.carts = next;
          console.log('a2 sss' + this.carts);
          if (this.carts.length === 1) {
            this.router.navigateByUrl('/checkout');
          } else {
            this.router.navigateByUrl('/cart');
          }
        });
      });
    } else {
      this.router.navigate(['/sign-in']);
    }
  }

  getDate() {
    this.orderService.getDateCourseBuy(this.id, +this.tokenService.getId()).subscribe(next => {
      if (next) {
        this.purchase = next;
        const now = new Date();
        const nowString = now.toISOString().substring(0, 10);
        const dateBuy = new Date(this.purchase.orderDate);
        dateBuy.setDate(dateBuy.getDate() + this.course.courseDuration * 7);
        this.endDate = dateBuy.toISOString().substring(0, 10);
        if (nowString >= this.purchase.orderDate && nowString <= this.endDate) {
          this.isPurchaseAvailable = true;
        }
      } else {
        this.purchase = null;
      }
    });
  }
}
