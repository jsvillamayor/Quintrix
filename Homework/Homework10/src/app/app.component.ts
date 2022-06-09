import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: `./app.component.html`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Homework10';
  namesArray: Array<any>;
  _http: HttpClient;
  parentFuncRef: Function;
  operations: Array<any>;
  dataFromChild: string;
  cutContent: string;
  constructor(private http: HttpClient){
    this._http = http;
  }
  myMouseHandler(event: any, description: string) {
      console.log(description + " X: "
      + event.screenX.toString()
      + " Y:" + event.screenY.toString())
    }
  cutEvent(content: string){
    this.cutContent = content;
  }
  pasteContent(){
    console.log(this.cutContent);
    this.cutContent = '';
  }
  myFocusEvent(description: string){
    console.log(description);
  }
  myMouseEnter(){
    console.log("Mouse entered!");
  }
  myKeyDown(event: any){
    console.log(event.key);
  }
  public ngOnInit(){
    this.parentFuncRef = this.myCallBackFunction.bind(this);
  }
  public myCallBackFunction(streetAddress: string, city: string, region: string){
    this.dataFromChild = "Street Address: " + streetAddress + ", " + "City: " + city + ", Region: " + region;
  }
  getSomeData(){
    this._http.get<any>('./assets/test.json').subscribe(
                                                        result => {this.namesArray = result},
                                                        error => {
                                                          alert(error);
                                                          console.error(error)
                                                          }
                                                        )
  }
}
