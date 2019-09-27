import { Component, OnInit, Inject, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../user';
import { PatientsComponent } from '../patients/patients.component';
import { PatientInfoComponent } from '../patient-info/patient-info.component';
import { UserInfoComponent } from '../user-info/user-info.component';
import { TransferService } from '../transfer/transfer.service';

declare var $: any;

@Component({
  selector: 'app-pre-login',
  templateUrl: './pre-login.component.html',
  styleUrls: ['./pre-login.component.css']
})

export class PreLoginComponent implements OnInit {

 user: User;

  constructor(private router: Router, private userService: UserService, private userPage: UserInfoComponent,
              private transferService: TransferService) {
      this.user = new User();
   }

  userSignUp = new FormGroup({
    firstname: new FormControl(''),
    lastname:  new FormControl(''),
    username:  new FormControl(''),
    password:  new FormControl(''),
    repassword:  new FormControl('')
  });

  userLogin = new FormGroup({
    username:  new FormControl(''),
    password:  new FormControl('')
  });


 ngOnInit(): void {}

 login(): void {
    this.user.username = this.userLogin.value.username;
    this.user.password = this.userLogin.value.password;
    console.log(this.userLogin.value);
    console.log(this.user);
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    this.userService.findByName(this.user).subscribe(data => {
      this.user = data;
      this.transferService.setUser(this.user);
      console.log(data);
      console.log(this.user);
      this.router.navigate(['/app-hospitals']);
    });
 }

  signup(): void {
    if (this.userSignUp.value.password === this.userSignUp.value.repassword) {
      this.user.firstName = this.userSignUp.value.firstname;
      this.user.lastName = this.userSignUp.value.lastname;
      this.user.username = this.userSignUp.value.username;
      this.user.password = this.userSignUp.value.password;
      console.log(this.userSignUp.value);
      console.log(this.user);
      $('.modal').removeClass('in');
      $('.modal').attr('aria-hidden', 'true');
      $('.modal').css('display', 'none');
      $('.modal-backdrop').remove();
      $('body').removeClass('modal-open');
      this.userService.save(this.user).subscribe(data => {
        console.log('login as ' + data);
      });
      this.router.navigate(['/app-hospitals']);
    } else {
      alert('Password don\'t match');
    }
  }
}

