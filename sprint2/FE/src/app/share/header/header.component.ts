import {Component, OnInit} from '@angular/core';
import {NavigationEnd, Router} from '@angular/router';
import {filter} from 'rxjs/operators';
import {TokenService} from '../../service/token.service';
import {ShareService} from '../../service/share.service';
import {User} from '../../model/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
// mặc định undefine
  isHomePage: boolean;
  isSignInPage = false;
  isSignUpPage = false;
  isLogined = false;
  name: string;
  username: string;
  role?: string;
  user: User;

  constructor(private router: Router,
              private tokenService: TokenService,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    this.isLogined = this.tokenService.isLogined();
    this.loading();
    this.shareService.getClickEvent().subscribe(next => {
      this.isLogined = this.tokenService.isLogined();
      this.loading();
    });
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.isHomePage = this.router.url === '/' || this.router.url === '/sign-in' || this.router.url === '/sign-up';
      });
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.isSignInPage = this.router.url === '/sign-in';
      });
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.isSignUpPage = this.router.url === '/sign-up';
      });
  }

  // getAll(){
  //   this.
  // }
  logOut() {
    this.tokenService.signOut();
    this.role = 'none';
    this.router.navigateByUrl('/');
    this.shareService.sendClickEvent();
    this.isLogined = false;
  }

  loading(): void {
    if (this.tokenService.getToken()) {
      this.role = this.tokenService.getRole();
      this.name = this.tokenService.getName();
      this.tokenService.setName(this.name);
      console.log(this.role);
    }
    this.isLogined = this.name != null;
    this.tokenService.getName();
    this.router.navigateByUrl('/');
  }
}
