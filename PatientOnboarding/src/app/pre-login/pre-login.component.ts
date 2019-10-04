import { Component, OnInit, Inject, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../user';
import { PatientsComponent } from '../patients/patients.component';
import { PatientInfoComponent } from '../patient-info/patient-info.component';
import { UserInfoComponent } from '../user-info/user-info.component';
import { TransferService } from '../transfer/transfer.service';
import { Role } from '../role';

declare var $: any;

@Component({
  selector: 'app-pre-login',
  templateUrl: './pre-login.component.html',
  styleUrls: ['./pre-login.component.css']
})

export class PreLoginComponent implements OnInit {

  user: User;
  role: Role;

  constructor(private router: Router, private userService: UserService, private userPage: UserInfoComponent,
              private transferService: TransferService) {
    this.user = new User();
    this.role = new Role();
  }

  userSignUp = new FormGroup({
    firstname: new FormControl(''),
    middleinit: new FormControl(''),
    lastname: new FormControl(''),
    email: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
    repassword: new FormControl('')
  });

  userLogin = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl('')
  });


  ngOnInit(): void { }

  //  login(): void {
  //     this.user.username = this.userLogin.value.username;
  //     this.user.password = this.userLogin.value.password;
  //     $('.modal').removeClass('in');
  //     $('.modal').attr('aria-hidden', 'true');
  //     $('.modal').css('display', 'none');
  //     $('.modal-backdrop').remove();
  //     $('body').removeClass('modal-open');
  //     if (this.userLogin.value.role === 'patient') {
  //       this.userService.findByPatientName(this.user).subscribe(data => {
  //         this.user = data;
  //         if (this.user === null) {
  //           alert('Invalid credentials');
  //         } else {
  //         this.transferService.setUser(this.user);
  //         this.router.navigate(['/app-user-home']);
  //         }
  //       });
  //     } else if (this.userLogin.value.role === 'admin') {
  //       this.userService.findByAdminName(this.user).subscribe(data => {
  //         this.user = data;
  //         if (this.user === null) {
  //           alert('Invalid credentials');
  //         } else {
  //         this.transferService.setUser(this.user);
  //         this.router.navigate(['/app-hospitals']);
  //         }
  //       });
  //     }  else if (this.userLogin.value.role === 'doctor') {
  //       this.userService.findByDoctorName(this.user).subscribe(data => {
  //         this.user = data;
  //         if (this.user === null) {
  //           alert('Invalid credentials');
  //         } else {
  //         this.transferService.setUser(this.user);
  //         this.router.navigate(['/app-doc-hospital']);
  //         }
  //       });
  //     } else {
  //       alert('Please select a role');
  //     }

  //  }

  signup(): void {
    if (this.userSignUp.value.password === this.userSignUp.value.repassword) {
      this.user.firstName = this.userSignUp.value.firstname;
      this.user.lastName = this.userSignUp.value.lastname;
      this.user.middleInit = this.userSignUp.value.middleinit;
      this.user.email = this.userSignUp.value.email;
      this.user.username = this.userSignUp.value.username;
      this.user.password = this.userSignUp.value.password;
      if (this.user.firstName === '' || this.user.lastName === '' ||
        this.user.middleInit === '' || this.user.email === '' ||
        this.user.username === '' || this.user.password === '') {
        alert('Please fill in all fields');
        this.router.navigate(['/app-pre-login']);
      } else {
        $('.modal').removeClass('in');
        $('.modal').attr('aria-hidden', 'true');
        $('.modal').css('display', 'none');
        $('.modal-backdrop').remove();
        $('body').removeClass('modal-open');
        this.userService.save(this.user).subscribe(data => {
          this.user = data;
          if (this.user === null) {
            alert('Username or email already exists');
            this.router.navigate(['/app-pre-login']);
          } else {
            // this.role.role = 'Patient';
            // this.user.role = this.role;
            this.transferService.setUser(this.user);
            this.router.navigate(['/app-user-home']);
          }
        });
      }
    } else {
      alert('Passwords don\'t match');
    }
  }

  login(): void {
    this.user.username = this.userLogin.value.username;
    this.user.password = this.userLogin.value.password;
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    // tslint:disable-next-line: deprecation
    this.userService.findByPatientName(this.user).subscribe(data => {
      console.log('1 ' + data);
      if (data !== null) {
        this.user = data;
        this.transferService.setUser(this.user);
        this.router.navigate(['/app-user-home']);
      } else {
        // tslint:disable-next-line: deprecation
        this.userService.findByAdminName(this.user).subscribe(datad => {
          console.log('2 ' + datad);
          if (datad !== null) {
            this.user = datad;
            this.transferService.setUser(this.user);
            this.router.navigate(['/app-hospitals']);
          } else {
            // tslint:disable-next-line: deprecation
            this.userService.findByDoctorName(this.user).subscribe(datag => {
              if (datag !== null) {
                console.log('3 ' + datag);
                this.user = datag;
                this.transferService.setUser(this.user);
                this.router.navigate(['/app-doc-hospital']);
              } else {
                alert('Invalid credentials');
              }
            });
          }
        });
      }
    });
  }

}
