import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './share/header/header.component';
import {FooterComponent} from './share/footer/footer.component';
import {FacilityListComponent} from './facility/facility-list/facility-list.component';
import {FacilityCreateComponent} from './facility/facility-create/facility-create.component';
import {FacilityEditComponent} from './facility/facility-edit/facility-edit.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {CustomerCreateComponent} from './customer/customer-create/customer-create.component';
import {ContractCreateComponent} from './contract/contract-create/contract-create.component';
import {ContractListComponent} from './contract/contract-list/contract-list.component';
import {HomeComponent} from './home/home.component';
import {CustomerModule} from './customer/customer.module';
import {EmployeeListComponent} from './employee/employee-list/employee-list.component';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    FacilityListComponent,
    FacilityCreateComponent,
    FacilityEditComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerCreateComponent,
    ContractCreateComponent,
    ContractListComponent,
    HomeComponent,
    EmployeeListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
