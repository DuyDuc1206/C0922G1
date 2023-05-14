import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, ActivatedRoute} from '@angular/router';
import {Observable, of} from 'rxjs';
import {OrderService} from '../service/cart/order.service';
import {TokenService} from '../service/token.service';
import {catchError, map} from 'rxjs/operators';
import {Purchase} from '../model/purchase';
import {Course} from '../model/course';
import {CourseService} from '../service/course/course.service';

@Injectable({
  providedIn: 'root'
})
export class PaymentGuard implements CanActivate {
  endDate: string = '';
  course: Course = {};

  constructor(private orderService: OrderService,
              private tokenService: TokenService,
              private courseService: CourseService,
              private router: Router) {

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    const idCourse = +next.paramMap.get('idCourse');
    const idUser = +this.tokenService.getId();
    //lấy course
    this.courseService.getCourseById(idCourse).subscribe(data => {
      this.course = data;
    });

    return this.orderService.getDateCourseBuy(idCourse, idUser).pipe(
      map((purchase: Purchase) => {
        if (purchase) {
          console.log('purchase + sdasđsa', purchase);
          // Kiểm tra xem thời gian hiện tại có nằm trong thời gian học khóa học hay không
          const now = new Date();
          const nowString = now.toISOString().substring(0, 10);
          const startDate = new Date(purchase.orderDate);
          startDate.setDate(startDate.getDate() + this.course.courseDuration * 7);
          this.endDate = startDate.toISOString().substring(0, 10);
          if (nowString >= purchase.orderDate && nowString <= this.endDate) {
            // Trả về true nếu thời gian hiện tại nằm trong thời gian học khóa học
            return true;
          }
          if (nowString < purchase.orderDate || nowString > this.endDate) {
            // Trả về false nếu thời gian hiện tại nằm ngoài thời gian học khóa học
            this.router.navigate(['/error']);
            return false;
          }
        }

        // Nếu không mua khóa học hoặc không nằm trong thời gian học, redirect đến trang thanh toán
        this.router.navigate(['/error']);
        return false;
      }),
      catchError(() => {
        // Nếu có lỗi trong quá trình kiểm tra, redirect đến trang lỗi
        this.router.navigate(['/course', idCourse]);
        return of(false);
      })
    );
  }
}
