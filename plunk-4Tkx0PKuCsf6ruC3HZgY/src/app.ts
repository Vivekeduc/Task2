//our root app component
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {App} from './app.component';
import {RegisterComponent} from './register.component';

@NgModule({
  imports: [ BrowserModule, FormsModule ],
  declarations: [ App,RegisterComponent ],
  bootstrap: [RegisterComponent ]
})
export class AppModule {}