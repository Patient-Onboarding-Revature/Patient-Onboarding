import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PreLoginComponent } from './pre-login/pre-login.component';

import { UserHomeComponent } from './user-home/user-home.component';
import { PatientInfoComponent } from './patient-info/patient-info.component';
import { HospitalsComponent } from './hospitals/hospitals.component';
import { RouterModule } from '@angular/router';
import { HospitalInfoComponent } from './hospital-info/hospital-info.component';

@NgModule({
  declarations: [
    AppComponent,
    PreLoginComponent,

    UserHomeComponent,
    PatientInfoComponent,
    HospitalsComponent,
    HospitalInfoComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: 'user_home', component: UserHomeComponent},
      {path: '**', redirectTo: 'user_home', pathMatch: 'full'}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
