import { Component } from '@angular/core';

export class PlayingCard{
  cardVal: string;
  suit: string;
}

@Component({
  selector: 'app-root',
  template: `
            <section>
              <form #myForm="ngForm">
                First Name:
                <input type="text" pattern="[a-zA-Z]*" minlength="3" required [(ngModel)]="myName" name="firstName" #firstName="ngModel" placeholder="Enter your first name">
                <div [hidden]="firstName.valid || firstName.pristine">
                  This control is invalid. 
                </div>
                <p *ngIf="firstName?.errors?.['required']">First name is required</p>
                <p *ngIf="firstName?.errors?.['pattern']">Only alphabetical characters are allowed.</p>
                <p *ngIf="firstName?.errors?.['minlength']">first name must have at least 3 characters.</p><br/>
                Last Name:
                <input type="text" pattern="[a-zA-Z]*" minlength="2" required [(ngModel)]="myLastName" name="lastName" #lastName="ngModel" placeholder="Enter your last name">
                <div [hidden]="lastName.valid || lastName.pristine">
                  This control is invalid. 
                </div>
                <p *ngIf="lastName?.errors?.['required']">Last name is required</p>
                <p *ngIf="lastName?.errors?.['pattern']">Only alphabetical characters are allowed.</p>
                <p *ngIf="lastName?.errors?.['minlength']">Last name must have at least 2 characters.</p><br/>
                <button type="submit" class="btn btn-default" [disabled]="!myForm.form.valid" (click)="onSubmit()">Submit</button>
              </form>
            </section>
            `
})

export class AppComponent {
  title = 'Homework9';
  myinput = '';
  myoutput = '';
  selectedCard: PlayingCard;
  myName: string;
  myLastName: string;
  doSomething(someContent: string){
    alert(someContent);
  }
  cards: PlayingCard[] = [
    {cardVal: "Ace", suit: "Spades"},
    {cardVal: "Two", suit: "Clubs"},
    {cardVal: "Six", suit: "Hearts"}
  ]
  onSelect(card: PlayingCard){
    alert(card.suit);
    this.selectedCard = card;
  }
  onSubmit(){
    alert(this.myName + " " + this.myLastName);
  }
  constructor(){
    
  }
}

