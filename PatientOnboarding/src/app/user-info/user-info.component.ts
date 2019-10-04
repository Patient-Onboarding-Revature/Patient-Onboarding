import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../user';
import { TransferService } from '../transfer/transfer.service';
import { HealthRecord } from '../user-health-record/healthrecord';

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

  healthRecord = new HealthRecord();
  http: any;
  file: any;

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


selecetdFile: File;
imagePreview: string;

  ngOnInit() {
    this.user = this.transferService.getUser();
    this.userService.getHealth(this.user).subscribe(data => {
      if (data != null) {
        this.healthRecord = data;
      }
    });

  }

  edit(): void {
    console.log(this.userEdit.value.firstname);
    // if (this.userEdit.value.firstname === '') {
    //   alert('First name field must be filled');
    // } else if (this.userEdit.value.lastname === '') {
    //   alert('Last name field must be filled');
    // } else if (this.userEdit.value.email === '') {
    //   alert('Email field must be filled');
    // } else {
      // this.user.firstName = this.userEdit.value.firstname;
      // this.user.lastName = this.userEdit.value.lastname;
    this.user.address = this.userEdit.value.address;
    this.user.email = this.userEdit.value.email;
    this.user.middleInit = this.userEdit.value.middleinit;
    this.user.state = this.userEdit.value.state;
    this.user.zip = this.userEdit.value.zip;
    this.user.number = this.userEdit.value.number;
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    this.userService.update(this.user).subscribe(data => {
    });
   // }
  }

  // onFileUpload(event) {
  //   console.log('event ' + event);
  //   this.file = event.target.files[0];
  //   console.log('event target ' + this.file);
  //   this.http.post('yourdomain.com/file-upload', this.file)
  //   .subscribe(...);
  //   }
    onFileUpload(event) {
    this.selecetdFile = event.target.files[0];
    const reader = new FileReader();
    reader.onload = () => {
    console.log('result ' + reader.result);
    this.imagePreview = reader.result.toString();
    };
    reader.readAsDataURL(this.selecetdFile);
    }
    // OnUploadFile() {
    // this.http.post('yourdomain.com/file-upload', this.selectedFile)
    // .subscribe(...);
    // }

}
