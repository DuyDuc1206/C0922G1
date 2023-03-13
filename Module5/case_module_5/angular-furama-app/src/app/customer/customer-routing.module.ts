import {NgModule} from '@angular/core';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: '', component: CustomerListComponent},
  {path: 'edit/:id', component: CustomerEditComponent},
  {path: 'create', component: CustomerCreateComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule {
}
