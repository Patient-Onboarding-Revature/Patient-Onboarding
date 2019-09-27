import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private urlsave: string;
  private urlupdate: string;
  private urlselect: string;
  private urllogin: string;

  constructor(private http: HttpClient) {
    this.urlsave = 'http://34.68.184.228/PatientOnboarding/api/insertuser.app';
    this.urlupdate = 'http://34.68.184.228/PatientOnboarding/api/updateuser.app';
    this.urlselect = 'http://34.68.184.228/PatientOnboarding/api/selectuser.app';
    this.urllogin = 'http://34.68.184.228/PatientOnboarding/api/loginuser.app';
  }

  public save(user: User): Observable<string[]> {
    return this.http.post<string[]>(this.urlsave, user);
  }

  public update(user: User): Observable<string[]> {
    return this.http.post<string[]>(this.urlupdate, user);
  }

  public selectAll(): Observable<User[]> {
    return this.http.get<User[]>(this.urlselect);
  }

  public findByName(user: User): Observable<User> {
    return this.http.post<User>(this.urllogin, user);
  }

}
