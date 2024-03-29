import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CourseComponent} from './course-list/course.component';
import {CourseDetailComponent} from './course-detail/course-detail.component';
import {LessonComponent} from './lesson/lesson.component';
import {AuthGuard} from '../security/auth.guard';
import {PaymentGuard} from '../security/payment.guard';


const routes: Routes = [
  {path: '', component: CourseComponent},
  {path: ':id', component: CourseDetailComponent},
  {path: ':idCourse/lesson/:idLesson', component: LessonComponent,canActivate:[PaymentGuard]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CourseRoutingModule { }
