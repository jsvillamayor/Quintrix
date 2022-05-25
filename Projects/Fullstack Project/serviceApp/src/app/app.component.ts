import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Website } from './website';
import { WebsiteService } from './website.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  website: Website = new Website();
  constructor(private websiteService:WebsiteService) { }
  tinyurl = "Your generated TinyUrl will appear here."

  public generateWebsite(){
    var resetForm = <HTMLFormElement>document.getElementById("urlForm");
    this.websiteService.addWebsite(this.website).subscribe(
      (response: Website) => {
        console.log(response);
        resetForm.reset();
        this.tinyurl = "Your TinyUrl is: " + response.tinyUrl;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        resetForm.reset();
      }
    )

  }

}
