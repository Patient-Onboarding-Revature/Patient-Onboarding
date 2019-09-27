import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../user';
import { TransferService } from '../transfer/transfer.service';
import { HealthRecord } from './healthrecord';

declare var $: any;

@Component({
  selector: 'app-user-health-record',
  templateUrl: './user-health-record.component.html',
  styleUrls: ['./user-health-record.component.css']
})
export class UserHealthRecordComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute, private userService: UserService,
              private transferService: TransferService, private healthRecord: HealthRecord) { }

  userHealthRecord = new FormGroup({
    bloodpressure: new FormControl(''),
    heartDisease: new FormControl(''),
    stroke: new FormControl(''),
    diabetes: new FormControl(''),
    digestive: new FormControl(''),
    lung: new FormControl(''),
    visual: new FormControl(''),
    joint: new FormControl(''),
    depression: new FormControl(''),
    cancer: new FormControl(''),
    liver: new FormControl(''),
    thyroid: new FormControl(''),
    hearing: new FormControl(''),
    drugs: new FormControl(''),
    sexually: new FormControl(''),
    exercise: new FormControl(''),
    livingWill: new FormControl(''),
    smoke: new FormControl(''),
    smokefreq: new FormControl(''),
    tobacco: new FormControl(''),
    tobaccofreq: new FormControl(''),
    alcohol: new FormControl(''),
    alcoholfreq: new FormControl(''),
    caffeinated: new FormControl(''),
    caffeinatedfreq: new FormControl(''),
  });

  ngOnInit() {
  }

  save(): void {
    console.log(this.userHealthRecord.value);
    this.healthRecord = this.userHealthRecord.value;
    console.log(this.healthRecord);
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    // this.userService.update(this.user).subscribe(data => {
    //   console.log(data);
    // });
  }

}
