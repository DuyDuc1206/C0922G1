import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { TodoComponent } from './todo/todo-page/todo.component';
import { TodoCreateComponent } from './todo/todo-create/todo-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { TodoEditComponent } from './todo/todo-edit/todo-edit.component';
import { TodoDeleteComponent } from './todo/todo-delete/todo-delete.component';
import { CategoryComponent } from './category/category/category.component';
import { CategoryCreateComponent } from './category/category-create/category-create.component';
import { CategoryUpdateComponent } from './category/category-update/category-update.component';
import { ProductComponent } from './product/product/product.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductUpdateComponent } from './product/product-update/product-update.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    TodoCreateComponent,
    TodoEditComponent,
    TodoDeleteComponent,
    CategoryComponent,
    CategoryCreateComponent,
    CategoryUpdateComponent,
    ProductComponent,
    ProductCreateComponent,
    ProductUpdateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
