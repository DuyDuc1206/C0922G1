import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {FacilityListComponent} from './facility/facility-list/facility-list.component';
import {HomeComponent} from './home/home.component';
import {ContractListComponent} from './contract/contract-list/contract-list.component';
import {FacilityEditComponent} from './facility/facility-edit/facility-edit.component';
import {FacilityCreateComponent} from './facility/facility-create/facility-create.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'facility', component: FacilityListComponent},
  {path: 'facility/create', component: FacilityCreateComponent},
  // {path: 'facility/edit/:id', component: FacilityEditComponent},
  {path: 'customer', loadChildren: () => import('./customer/customer.module').then((m) => m.CustomerModule)},
  {path: 'contract', component: ContractListComponent},
  {path: '', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
