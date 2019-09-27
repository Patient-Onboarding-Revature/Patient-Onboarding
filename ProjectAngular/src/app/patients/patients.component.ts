import { Component } from '@angular/core';
import { Patients } from './patients';
import { User } from '../user';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent {
  pageTitle = 'Patints List';

  patients: User[];
  filterPatients: User[];

  user: User;

  // filter info
  filterValue = '';

  get inputField() {
      return this.filterValue;
  }

  set inputField(temp: string) {
      this.filterValue = temp;
      this.filterPatients = this.filterValue ? this.perfomFilter(this.filterValue) : this.patients;
  }

  constructor(private userService: UserService) {
      this.userService.selectAll().subscribe(data => {
        this.patients = data;
        console.log(data);
        console.log(this.patients);
      });
      this.patients = this.patients;
  }


  perfomFilter(filterValue: string): User[] {
      filterValue = filterValue.toLocaleLowerCase();

      return this.patients.filter((patient: User) =>
          patient.lastName.toLocaleLowerCase().indexOf(filterValue)
          !== -1);
  }

  findbyName(lastname: string) {
    let patient: User;
    console.log('iampddsgdsgatiemt' + this.patients);
    this.patients.forEach(element => {
      if (element.lastName === lastname) {
        patient = element;
        console.log('iampatiemt' + patient);
      }
    });
    return patient;
  }

  setUser(user: User): User {
    this.user = user;
    console.log('get user ' + this.user.firstName);
    return this.user;
  }

  starEventWasTriggered(temp: string): void {
      this.pageTitle = temp;
  }

}
