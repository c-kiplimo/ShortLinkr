import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UrlShortenerService {

  constructor(private http: HttpClient) {
   }
   createLink(dataObj: any): Observable<any> {
    return this.http.post<any>(environment.baseUrl + '/shortener/create-short', dataObj, { observe: 'response' });
  }
}

