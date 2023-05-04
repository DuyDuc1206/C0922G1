import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './share/home/home.component';
import {CourseComponent} from './course/course.component';
import {BlogComponent} from './blog/blog.component';
import {ContactComponent} from './contact/contact.component';
import {SignInComponent} from './sign-in/sign-in.component';
import {SignUpComponent} from './sign-up/sign-up.component';
import {CartComponent} from './cart/cart.component';
import {CourseDetailComponent} from './course-detail/course-detail.component';
import {LessonComponent} from './lesson/lesson.component';
import {ErrorComponent} from './error/error.component';
import {CheckoutComponent} from './checkout/checkout.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  // {path: 'home', component: HomeComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'sign-in', component: SignInComponent},
  {path: 'course', component: CourseComponent},
  {path: 'course/:id', component: CourseDetailComponent},
  {path: 'blog', component: BlogComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'cart', component: CartComponent},
  {path: 'course/:idCourse/lesson/:idLesson', component: LessonComponent},
  {path: 'cart', component: CartComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'checkout', component: CheckoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
