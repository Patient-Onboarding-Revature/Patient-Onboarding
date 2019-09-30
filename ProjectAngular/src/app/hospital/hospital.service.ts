import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hospital } from './hospital';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  private urlselect: string;
  private urlHospId: string;

  constructor(private http: HttpClient) {
    this.urlselect = 'http://localhost:9009/PatientOnboarding/api/selecthospital.app';
    this.urlHospId = 'http://localhost:9009/PatientOnboarding/api/selecthospitalid.app';
  }

  public selectAll(): Observable<Hospital[]> {
    return this.http.get<Hospital[]>(this.urlselect);
  }

  public findByHospId(hospital: Hospital): Observable<Hospital> {
    return this.http.post<Hospital>(this.urlHospId, hospital);
  }

}
