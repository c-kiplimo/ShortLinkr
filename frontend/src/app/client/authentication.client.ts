
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationClient {
  constructor(private http: HttpClient) {}

  public login(email: string, password: string): Observable<any> {
    return this.http.post(
      environment.baseUrl + '/api/login',
      {
        usernameOrEmail: email,
        password: password,
      },
    );
  }

  public register(
    username: string,
    email: string,
    password: string
  ): Observable<any> {
    return this.http.post(
      environment.baseUrl + '/api/register',
      {
        username: username,
        email: email,
        password: password,
      },
    );
  }
}