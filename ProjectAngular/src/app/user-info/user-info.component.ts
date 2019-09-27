import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../user';
import { TransferService } from '../transfer/transfer.service';

declare var $: any;

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute, private userService: UserService,
              private transferService: TransferService, private user: User) {
               }

  userEdit = new FormGroup({
    firstname: new FormControl(''),
    lastname: new FormControl(''),
    middleinit: new FormControl(''),
    address: new FormControl(''),
    state: new FormControl(''),
    zip: new FormControl(''),
    number: new FormControl(''),
    email: new FormControl('')
  });

  ngOnInit() {
    this.user = this.transferService.getUser();
    console.log(this.user);
  }

  edit(): void {
    this.user.firstName = this.userEdit.value.firstname;
    this.user.lastName = this.userEdit.value.lastname;
    this.user.address = this.userEdit.value.address;
    this.user.email = this.userEdit.value.email;
    this.user.middleInit = this.userEdit.value.middleinit;
    this.user.state = this.userEdit.value.state;
    this.user.zip = this.userEdit.value.zip;
    this.user.number = this.userEdit.value.number;
    console.log(this.user);
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
