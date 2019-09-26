import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { PreLoginComponent } from './pre-login/pre-login.component';
import { HttpClientModule } from '@angular/common/http';
import { UserHomeComponent } from './user-home/user-home.component';
import { PatientInfoComponent } from './patient-info/patient-info.component';
import { HospitalsComponent } from './hospitals/hospitals.component';
import { RouterModule } from '@angular/router';
import { HospitalInfoComponent } from './hospital-info/hospital-info.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserService } from './user/user.service';
import { PatientsComponent } from './patients/patients.component';

@NgModule({
  declarations: [
    AppComponent,
    PreLoginComponent,
    UserHomeComponent,
    PatientInfoComponent,
    HospitalsComponent,
    HospitalInfoComponent,
    NavbarComponent,
    PatientsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'app-pre-login', component: PreLoginComponent},
      {path: 'user_home', component: UserHomeComponent},
      {path: 'app-patients', component: PatientsComponent},
      {path: 'app-hospitals', component: HospitalsComponent},
      {path: 'app-hospital-info', component: HospitalInfoComponent},
      {path: 'app-patient-info/:patientname', component: PatientInfoComponent},
      {path: '**', redirectTo: 'app-pre-login', pathMatch: 'full'}
    ])
  ],
  providers: [UserService, PatientsComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
