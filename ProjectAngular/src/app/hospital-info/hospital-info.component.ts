import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hospital } from '../hospital/hospital';
import { HospitalService } from '../hospital/hospital.service';

@Component({
  selector: 'app-hospital-info',
  templateUrl: './hospital-info.component.html',
  styleUrls: ['./hospital-info.component.css']
})
export class HospitalInfoComponent implements OnInit {

  currentHospital: Hospital;
  currentHospitalId = 'no id';
  hospital: Hospital;

  constructor(private route: ActivatedRoute, private hospService: HospitalService) {
    this.hospital = new Hospital();
  }

  ngOnInit() {
    this.currentHospitalId = this.route.snapshot.paramMap.get('id');
    this.hospital.id = parseInt(this.currentHospitalId, 10);
    this.hospService.findByHospId(this.hospital).subscribe(data => {
      this.currentHospital = data;
      return this.currentHospital;
    });
  }

}
