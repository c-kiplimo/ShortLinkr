import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  username: any = {};
  email: any = {};

  constructor() { }

  ngOnInit(): void {
    this.username = JSON.parse(sessionStorage.getItem('username') || '{}');
    this.email = this.username?.email;  
  }

  logOut() {
    localStorage.removeItem('token');
  }
}
