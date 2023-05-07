import {Component, OnInit} from '@angular/core';
import {CourseService} from '../service/course/course.service';
import {Course} from '../model/course';
import {ActivatedRoute, Router} from '@angular/router';
import {Lesson} from '../model/lesson';
import {LessonService} from '../service/course/lesson.service';
import {CartService} from '../service/cart/cart.service';
import {ShareService} from '../service/share.service';
import Swal from 'sweetalert2';
import {TokenService} from '../service/token.service';
import {User} from '../model/user';
import {Cart} from '../model/cart';
import {AuthService} from '../service/auth.service';

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
  size = 2;
  isLogged = false;
  user: User;
  carts: Cart[] = [];
  cart: Cart = {};
  quantity = 0;
  total = 0;

  constructor(private courseService: CourseService,
              private lessonService: LessonService,
              private cartService: CartService,
              private shareService: ShareService,
              private tokenService: TokenService,
              private router: Router,
              private authService: AuthService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.isLogged = this.tokenService.isLogined();
    this.check();
    // this.shareService.getClickEvent().subscribe(next => {
    //   this.isLogged = this.tokenService.isLogined();
    //   this.check()
    // })
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
      this.getCourse(this.id);
      this.getAllLessons(this.id);
    });
    this.getAllCourse(this.nameSearch, this.page, this.size);
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
      this.courses = data['content'];
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
        this.total += this.carts[i].course.price * this.carts[i].quantity;
      }
    }
  }

  addToCart() {
    if (this.isLogged) {
      this.cartService.addToCart(this.course, this.user).subscribe(next => {
        this.shareService.sendClickEvent()
        this.cartService.getCartByUser(this.id).subscribe( next => {
          this.carts = next;
          if (this.carts.length === 1) {
            this.router.navigateByUrl('/checkout');
          }else {
            this.router.navigateByUrl('cart');
          }
        })
      });

      // this.cartService.putQuantity(this.user.id, this.course.idCourse, 1, 'add').subscribe(next => {
      //     Swal.fire({
      //       title: 'Bạn đã thêm sản phẩm ' + this.course.courseName + ' vào giỏ!',
      //       imageUrl: this.course.thumbnail,
      //       showConfirmButton: false,
      //       timer: 2000,
      //       imageWidth: 200,
      //       imageHeight: 200,
      //       imageAlt: 'Custom image',
      //     });
      //     this.shareService.sendClickEvent();
      //   }
      // );
    } else {
      // this.tokenService.addCartSessionDetail(this.course, parseInt(quantity));
    }
  }
}
