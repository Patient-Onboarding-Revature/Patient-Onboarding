import { Component, OnInit, Inject, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../user';

declare var $: any;

@Component({
  selector: 'app-pre-login',
  templateUrl: './pre-login.component.html',
  styleUrls: ['./pre-login.component.css']
})

export class PreLoginComponent implements OnInit {

 user: User;

 closeResult: string;

  constructor(private router: Router, private userService: UserService) {
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
    console.log(this.userLogin.value);
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    this.router.navigate(['/app-hospitals']);
 }

  signup(): void {
    if (this.userSignUp.value.password === this.userSignUp.value.repassword) {
      this.user.firstname = this.userSignUp.value.firstname;
      this.user.lastname = this.userSignUp.value.lastname;
      this.user.username = this.userSignUp.value.username;
      this.user.password = this.userSignUp.value.password;
      console.log(this.userSignUp.value);
      console.log(this.user);
      $('.modal').removeClass('in');
      $('.modal').attr('aria-hidden', 'true');
      $('.modal').css('display', 'none');
      $('.modal-backdrop').remove();
      $('body').removeClass('modal-open');
      this.router.navigate(['/app-hospitals']);
      this.userService.save(this.user).subscribe(data => {
        console.log(data);
      });
    } else {
      alert('Password don\'t match');
    }
  }
}

