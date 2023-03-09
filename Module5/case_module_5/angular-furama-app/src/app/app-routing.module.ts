import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {FacilityListComponent} from './facility/facility-list/facility-list.component';
import {BodyComponent} from './body/body.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'body'},
  {path: 'facility', component: FacilityListComponent},
  {path: '', component: BodyComponent},
  {path: 'customer', component: CustomerListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
