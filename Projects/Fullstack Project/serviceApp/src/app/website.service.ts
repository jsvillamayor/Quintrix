import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Website } from './website';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WebsiteService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getWebsites(): Observable<Website[]>{
    return this.http.get<Website[]>(`${this.apiServerUrl}/tinyurl/all`)
  }

  public addWebsite(website: Website): Observable<Website>{
    return this.http.post<Website>(`${this.apiServerUrl}/tinyurl/add`, website);
  }

  public deleteWebsite(websiteId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/tinyurl/delete/${websiteId}`);
  }


}
