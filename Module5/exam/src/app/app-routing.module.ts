import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CarComponent} from "./car/car.component";
import {CarEditComponent} from "./car-edit/car-edit.component";
import {CarCreateComponent} from "./car-create/car-create.component";


const routes: Routes = [
  {path:'coach',component: CarComponent},
  {path:'coach/edit/:id', component: CarEditComponent},
  {path:'coach/create', component: CarCreateComponent},
   ]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
