import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './share/home/home.component';
import {BlogComponent} from './blog/blog.component';
import {ContactComponent} from './contact/contact.component';
import {CartComponent} from './payment/cart/cart.component';
import {LessonComponent} from './course/lesson/lesson.component';
import {ErrorComponent} from './login/error/error.component';
import {CheckoutComponent} from './payment/checkout/checkout.component';
import {UserComponent} from './user/user.component';
import {AdminGuard} from './security/admin.guard';
import {PaymentGuard} from './security/payment.guard';
import {AuthGuard} from './security/auth.guard';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: '',  loadChildren: () => import('./login/login-routing.module').then((m)=>m.LoginRoutingModule)},
  {path: 'course', loadChildren: () => import('./course/course.module').then((m) => m.CourseModule)},
  {path: 'blog', component: BlogComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'cart', component: CartComponent,canActivate: [AdminGuard]},
  // {path: '**', redirectTo: 'error'},
  {path: 'error', component: ErrorComponent},
  {path: 'checkout', component: CheckoutComponent},
  {path: 'profile', component: UserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
