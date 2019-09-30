import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Patients } from '../patients/patients';
import { PatientsComponent } from '../patients/patients.component';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user/user.service';
import { TransferService } from '../transfer/transfer.service';
import { HealthRecord } from '../user-health-record/healthrecord';

declare var $: any;

@Component({
  selector: 'app-patient-info',
  templateUrl: './patient-info.component.html',
  styleUrls: ['./patient-info.component.css']
})
export class PatientInfoComponent implements OnInit {

  currentPatient = 'no name';
  curPatient: User;
  user: User;
  img = 'assets/user${this.curPatient}.jpeg';
  healthRecord = new HealthRecord();

  constructor(private route: ActivatedRoute, private userService: UserService) {
                this.user = new User();
               }

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
    this.currentPatient = this.route.snapshot.paramMap.get('userId');
    this.user.Id = parseInt(this.currentPatient, 10);
    this.userService.findByPatientId(this.user).subscribe(data => {
      this.curPatient = data;
      this.userService.getHealth(this.curPatient).subscribe(record => {
        this.healthRecord = record;
        console.log('from user page ' + this.healthRecord);
      });
      return this.curPatient;
    });

  }

  edit(): void {
    this.curPatient.firstName = this.userEdit.value.firstname;
    this.curPatient.lastName = this.userEdit.value.lastname;
   // this.user.username = this.userEdit.value.username;
   // this.user.password = this.userEdit.value.password;
    console.log(this.userEdit.value);
    console.log(this.curPatient);
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    this.userService.update(this.user).subscribe(data => {
      console.log(data);
    });
  }
}
