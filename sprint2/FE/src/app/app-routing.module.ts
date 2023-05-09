import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './share/home/home.component';
import {BlogComponent} from './blog/blog.component';
import {ContactComponent} from './contact/contact.component';
import {CartComponent} from './payment/cart/cart.component';
import {LessonComponent} from './course/lesson/lesson.component';
import {ErrorComponent} from './login/error/error.component';
import {CheckoutComponent} from './payment/checkout/checkout.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: '',  loadChildren: () => import('./login/login-routing.module').then((m)=>m.LoginRoutingModule)},
  {path: 'course', loadChildren: () => import('./course/course.module').then((m) => m.CourseModule)},
  {path: 'blog', component: BlogComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'cart', component: CartComponent},
  {path: 'course/:idCourse/lesson/:idLesson', component: LessonComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'checkout', component: CheckoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
