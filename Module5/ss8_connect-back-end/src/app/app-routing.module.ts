import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TodoComponent} from './todo/todo-page/todo.component';
import {TodoCreateComponent} from './todo/todo-create/todo-create.component';
import {TodoEditComponent} from './todo/todo-edit/todo-edit.component';
import {TodoDeleteComponent} from './todo/todo-delete/todo-delete.component';
import {CategoryComponent} from './category/category/category.component';
import {ProductComponent} from './product/product/product.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';


const routes: Routes = [
  {path: 'todo', component: TodoComponent},
  {path: 'todo/create', component: TodoCreateComponent},
  {path: 'todo/edit/:id', component: TodoEditComponent},
  {path: 'todo/delete/:id', component: TodoDeleteComponent},
  {path: 'category', component: CategoryComponent},
  {path: 'product', component: ProductComponent},
  {path: 'product/create', component: ProductCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
