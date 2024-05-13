import { Component, OnInit } from '@angular/core';
import { Chart, registerables } from 'chart.js';
import { AuthenticationService } from './../services/authentication.service';
import { UrlShortenerService } from '../shared/url-shortener.service';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
Chart.register(...registerables);

@Component({
  selector: 'app-dashboard-redisign',
  templateUrl: './dashboard-redisign.component.html',
  styleUrls: ['./dashboard-redisign.component.scss']
})
export class DashboardRedisignComponent implements OnInit {

   date:any = new Date(new Date().setDate(new Date().getDate() + 100)).toISOString().slice(0, 10);
   longUrl: String = '';
   shortUrl = '';
   copiedLink:boolean = false;

  constructor(
    private authenticationService: AuthenticationService,
    private urlShortenerService: UrlShortenerService,
    private http: HttpClient

  ) { }

  ngOnInit(): void {
      var myChart = new Chart("myChart", {
        type: 'bar',
        data: {
        labels: ['jan', 'feb', 'march', 'april', 'may', 'jun', 'jul', 'aug', 'sep', 'oct', 'nov', 'dec'],
            datasets: [{
                label: 'Total Bitlinks',
                data: [400, 380, 360, 400, 350, 390, 320, 250, 500, 350, 450, 550],
                backgroundColor: [
                    'rgb(20,99,255, 1)'
                ],
                borderColor: [
                    'rgba(0, 0, 0, 1)'
                ],
                borderWidth: 1,
                barPercentage:0.5

            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
      });
  }

  logout(): void {
    this.authenticationService.logout();
  }

  createShortLink(): void {
    const url = 'http://164.92.70.172:9191/shortener/create-short';
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

