import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { PageAComponent } from './app.page-a';
import { PageBComponent } from './app.page-b';
import { PageDefault } from './app.pagedefault';
import { routing } from './app.routing';
import { FahrenheitPipe } from './fahrenheitPipe';
import { NewDirectiveComponent } from './new-directive/new-directive.component';
import { NumberPipe } from './numberPipe';
import { ThirdDirectiveComponent } from './third-directive/third-directive.component';

@NgModule({
  declarations: [
    AppComponent,
    NewDirectiveComponent,
    ThirdDirectiveComponent,
    FahrenheitPipe,
    NumberPipe,
    PageAComponent,
    PageBComponent,
    PageDefault
  ],
  imports: [
    BrowserModule, routing, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
