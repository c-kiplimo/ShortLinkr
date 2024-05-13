
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './logincomponent.component.html',
  styleUrls: ['./logincomponent.component.scss'],
})
export class LogincomponentComponent implements OnInit {
  public loginForm!: FormGroup;

  change:boolean = true;
  visible:boolean = true;

  showpass(){
    this.change = !this.change;
    this.visible = !this.visible;
  }

  constructor(private authenticationService: AuthenticationService) {}

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  public onSubmit() {
    this.authenticationService.login(
      this.loginForm.get('email')!.value,
      this.loginForm!.get('password')!.value
    );
  }
}
