import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Patients } from '../patients/patients';
import { PatientsComponent } from '../patients/patients.component';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user/user.service';

declare var $: any;

@Component({
  selector: 'app-patient-info',
  templateUrl: './patient-info.component.html',
  styleUrls: ['./patient-info.component.css']
})
export class PatientInfoComponent implements OnInit {

  currentPatient = 'no name';
  curPatient: Patients;
  user: User;

  constructor(private route: ActivatedRoute, private setPat: PatientsComponent, private userService: UserService) { }

  userEdit = new FormGroup({
    firstname: new FormControl(''),
    lastname: new FormControl(''),
    middlename: new FormControl(''),
    salutation: new FormControl(''),
    suffix: new FormControl(''),
    streetaddress: new FormControl(''),
    state: new FormControl(''),
    zipcode: new FormControl(''),
    contactnum: new FormControl(''),
    email: new FormControl(''),
    marital: new FormControl(''),
    ethnicity: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
    race: new FormControl(''),
    sex: new FormControl(''),
  });

  ngOnInit() {
    this.currentPatient = this.route.snapshot.paramMap.get('patientname');
    this.curPatient = this.setPat.findbyName(this.currentPatient);
  }

  edit(): void {
    this.curPatient.firstname = this.userEdit.value.firstname;
    this.curPatient.lastname = this.userEdit.value.lastname;
   // this.user.username = this.userEdit.value.username;
   // this.user.password = this.userEdit.value.password;
    console.log(this.userEdit.value);
    console.log(this.curPatient);
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
  }
}
