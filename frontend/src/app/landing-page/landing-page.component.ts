import { Component, OnInit } from '@angular/core';
import {ModalService } from '../services/modal.service'
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss']
})
export class LandingPageComponent implements OnInit {

  constructor(private modalService: ModalService, private http:HttpClient) { }

  openModal(content: any){
    this.modalService.openVerticalModal(content);
  }

  ngOnInit(): void {
  }


}

// // landing-page.component.ts
// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-landing-page',
//   templateUrl: './landing-page.component.html',
//   styleUrls: ['./landing-page.component.css']
// })
// export class LandingPageComponent {
//   longUrl!: string;
//   shortUrl!: string;

//   shortenUrl() {
//     // Call your API to shorten the URL here
//     // The API should return the shortened URL
//     // Once it returns the shortened URL, you can assign it to the shortUrl variable
//     this.shortUrl = "https://linkify.com/abc123";
//   }
// }
