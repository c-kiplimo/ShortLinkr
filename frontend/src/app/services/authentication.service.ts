import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationClient } from '../client/authentication.client';
@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private tokenKey = 'token';

  constructor(
    private authenticationClient: AuthenticationClient,
    private router: Router
  ) {}

  public login(usernameOrEmail: string, password: string): void {
    this.authenticationClient.login(usernameOrEmail, password).subscribe((res: any) => {
      localStorage.setItem("tokenKey", res.bearerToken);
      // localStorage.setItem("token",res.bearerToken)
      // console.log(typeof res)
      this.router.navigate(['/dashboard']);
    });
  }

  public register(username: string, email: string, password: string): void {
    this.authenticationClient
      .register(username, email, password)
      .subscribe((token) => {
        console.log(token)
        // localStorage.setItem(this.tokenKey, token);
        this.router.navigate(['/login']);
      });
  }

  public logout() {
    localStorage.removeItem("tokenKey");
    this.router.navigate(['/login']);
  }

  public isLoggedIn(): boolean {
    let token = localStorage.getItem("tokenKey");
    return token != null && token.length > 0;
  }

  public getToken(): string | null {
    return this.isLoggedIn() ? localStorage.getItem("tokenKey") : null;
  }
}