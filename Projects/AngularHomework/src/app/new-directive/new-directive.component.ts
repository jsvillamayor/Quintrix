import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-new-directive',
  template: `<h3>This is the second directive!  {{firstName}}</h3>`,
})
export class NewDirectiveComponent implements OnInit {

  @Input()
  firstName: string;

  constructor() { }

  ngOnInit(): void {
  }

}
