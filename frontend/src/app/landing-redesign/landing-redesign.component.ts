import { Component, OnInit } from '@angular/core';
import { ModalService } from '../services/modal.service';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from './../services/authentication.service';
import { UrlShortenerService } from '../shared/url-shortener.service';


@Component({
  selector: 'app-landing-redesign',
  templateUrl: './landing-redesign.component.html',
  styleUrls: ['./landing-redesign.component.scss']
})
export class LandingRedesignComponent implements OnInit {

  date:any = new Date(new Date().setDate(new Date().getDate() + 100)).toISOString().slice(0, 10);
   longUrl: String = '';
   shortUrl = '';
   copiedLink:boolean = false;

  constructor(
    private modalService: ModalService, 
    private http:HttpClient,
    private authenticationService: AuthenticationService,
    private urlShortenerService: UrlShortenerService,
    

    ) { }

  openModal(content: any) {
    this.modalService.openVerticalModal(content);
  }
  
  ngOnInit(): void {
  }

  createShortLink(): void {
    const url = 'http://localhost:9191/shortener/create-short';
    const expiryDate = new Date(Date.now() + 365 * 24 * 60 * 60 * 1000); // One year from now
    const formattedDate = expiryDate.toISOString().substring(0, 10);
    
    const body = { longUrl: this.longUrl, formattedDate };
    this.http.post(url, body).subscribe((response: any) => {
      console.log(response);
      this.shortUrl = response.shortUrl;
    });
  }


  copyShortenedLink(): void {
    // genereate link
    if (!this.copiedLink) {
      // console.log('clicked');

      navigator.clipboard.writeText(this.shortUrl);
      this.copiedLink = true;

      setTimeout(() => {
        this.copiedLink = false;
      }, 3000);

    }

  }

}
