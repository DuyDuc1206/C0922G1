import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import {Observable, throwError} from 'rxjs';
import {TokenService} from '../service/token.service';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {catchError} from 'rxjs/operators';

@Injectable()
export class Http403Interceptor implements HttpInterceptor {
  constructor(private router: Router,
              private tokenService: TokenService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 403 && !this.tokenService.isLogined()) {
          // Redirect to a 403 error page or login page, or display a notification
          this.router.navigateByUrl('login');
        } else if (error.status === 403 && this.tokenService.isLogined()) {
          this.router.navigateByUrl('error');
        }
        return throwError(error);
      })
    );
  }
}
