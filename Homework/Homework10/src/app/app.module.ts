import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ChildComponent } from './child/child.component';
import { HighlightDirective } from './highlight.directive';

@NgModule({
  declarations: [
    AppComponent,
    ChildComponent,
    HighlightDirective
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
