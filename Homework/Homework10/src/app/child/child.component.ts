import { Component, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  template: `
            <table>
              <tr>
                <td>Street Address: </td>
                <td>&nbsp;&nbsp;</td>
                <td><input type="text" [(ngModel)]="streetAddress"></td>
              </tr>
              <tr>
                <td>City: </td>
                <td>&nbsp;&nbsp;</td>
                <td><input type="text" [(ngModel)]="city"></td>
              </tr>
              <tr>
                <td>Region: </td>
                <td>&nbsp;&nbsp;</td>
                <td><input type="text" [(ngModel)]="region"></td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td><input type="submit" (click)="submitInput()"></td>
              </tr>
            </table>
            `
})
export class ChildComponent implements OnInit {

  @Output()
  streetAddress: string;
  @Output()
  city: string;
  @Output()
  region: string;
  @Input()
  callParent: Function;
  
  submitInput(){
    this.callParent(this.streetAddress, this.city, this.region);
  }

  ngOnInit(): void {
  }

}
