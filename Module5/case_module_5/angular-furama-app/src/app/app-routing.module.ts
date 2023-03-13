import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {FacilityListComponent} from './facility/facility-list/facility-list.component';
import {HomeComponent} from './home/home.component';
import {ContractListComponent} from './contract/contract-list/contract-list.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'facility', component: FacilityListComponent},
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
