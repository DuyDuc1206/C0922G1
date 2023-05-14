import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './share/home/home.component';
import {HeaderComponent} from './share/header/header.component';
import {FooterComponent} from './share/footer/footer.component';
import {CourseComponent} from './course/course-list/course.component';
import {CartComponent} from './payment/cart/cart.component';
import {CourseDetailComponent} from './course/course-detail/course-detail.component';
import {SignInComponent} from './login/sign-in/sign-in.component';
import {BlogComponent} from './blog/blog.component';
import {ContactComponent} from './contact/contact.component';
import {SignUpComponent} from './login/sign-up/sign-up.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { LessonComponent } from './course/lesson/lesson.component';
import { ErrorComponent } from './login/error/error.component';
import {environment} from '../environments/environment';
import {AngularFireModule} from '@angular/fire';
import {AngularFireStorageModule} from '@angular/fire/storage';
import { CheckoutComponent } from './payment/checkout/checkout.component';
import { UserComponent } from './user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    CourseComponent,
    CartComponent,
    CourseDetailComponent,
    SignInComponent,
    BlogComponent,
    ContactComponent,
    SignUpComponent,
    LessonComponent,
    ErrorComponent,
    CheckoutComponent,
    UserComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    AngularFireStorageModule,
    AngularFireModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
