import { Component } from '@angular/core';
import { ConversionCtoFService } from './conversion-cto-f.service';
import { MyDataServiceService } from './my-data-service.service';


@Component({
  selector: 'app-root',
  template: `
            <h1>This is the header</h1>
            <nav>
              <a routerLink="/page-a" routerLinkActive="active">A</a> |
              <a routerLink="/page-b/5/bob" routerLinkActive="active">B</a>
            </nav>
            <router-outlet></router-outlet>
            `,
  providers: [MyDataServiceService, ConversionCtoFService]
})
export class AppComponent {
  title = 'This is Angular';
  names: Array<any>;
  f: number;
  mydate = new Date(2019, 8, 17, 18, 0, 30);
  price: number = 23.3393;
  celsius: number;
  phoneNumber: number;

  constructor(myDataService: MyDataServiceService, temperatureService: ConversionCtoFService){
    this.names = myDataService.getNames();
    this.f = temperatureService.getConversion();
    this.celsius = 33;
    this.phoneNumber = 8058133024;
  }

}
