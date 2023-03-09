import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {FacilityListComponent} from './facility/facility-list/facility-list.component';
import {BodyComponent} from './body/body.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'body'},
  {path: 'facility', component: FacilityListComponent},
  {path: 'body', component: BodyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
