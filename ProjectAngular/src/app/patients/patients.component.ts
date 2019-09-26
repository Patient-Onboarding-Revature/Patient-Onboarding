import { Component } from '@angular/core';
import { Patients } from './patients';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent {
  pageTitle = 'Patints List';

  patients: Patients[];
  filterPatients: Patients[];

  // filter info
  filterValue = '';

  get inputField() {
      return this.filterValue;
  }

  set inputField(temp: string) {
      this.filterValue = temp;
      this.filterPatients = this.filterValue ? this.perfomFilter(this.filterValue) : this.patients;
  }

  constructor() {
      this.patients = [
          {
              firstname: 'Maria',
              lastname: 'Abashina'
          },
          {
            firstname: 'Jacob',
            lastname: 'Hayhurst'
          },
          {
            firstname: 'Michael',
            lastname: 'Tang'
          },
          {
            firstname: 'David',
            lastname: 'Juarez'
          }
      ];
      this.filterPatients = this.patients;
  }

  perfomFilter(filterValue: string): Patients[] {
      filterValue = filterValue.toLocaleLowerCase();

      return this.patients.filter((patient: Patients) =>
          patient.lastname.toLocaleLowerCase().indexOf(filterValue)
          !== -1);
  }

  findbyName(lastname: string) {
    let patient: Patients;
    this.patients.forEach(element => {
      if (element.lastname === lastname) {
        patient = element;
      }
    });
    return patient;
  }

  starEventWasTriggered(temp: string): void {
      this.pageTitle = temp;
  }

}
