import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:9009/PatientOnboarding/api/insertuser.app';
  }

  public save(user: User): Observable<string[]> {
    return this.http.post<string[]>(this.url, user);
  }

}
