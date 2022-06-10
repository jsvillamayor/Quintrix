import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
              <p [ngStyle]='myStyles'>style binding example</p>
            `,
  styles:   [`
            .danger{
              color: orange;
              font-weight: bold;
            }
            .makemegreen{
              color: green;
              font-weight: bold;
            }
            .warning{
              font-weight: bold;
            }
            .dangerous{
              color: red;
            }
            .highrisk{
              text-decoration: underline;
            }
            `]
})
export class AppComponent {
  title = 'Homework11';
  foodWarning: Boolean;
  greenWarning: Boolean;
  property1 = true;
  property2 = true;
  property3 = true;
  doesNotExercise = false;
  over55 = false;
  myWeight = 'bold';
  myStyles = {
    'color': 'blue',
    'font-weight': 'bold'
  }
  myClasses = {
    warning: this.property1,
    dangerous: this.property2,
    highrisk: this.property3
  }
  adjustCSS(){

  }
  constructor(){
    this.foodWarning = false;
    this.greenWarning = false;
  }
}
