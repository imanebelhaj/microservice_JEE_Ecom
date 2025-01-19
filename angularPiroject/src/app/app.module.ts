import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientListComponent } from './components/client-list/client-list.component';
import {HttpClientModule} from '@angular/common/http';
import { ClientAddComponent } from './components/client-add/client-add.component';
import {FormsModule} from '@angular/forms';
import { ClientEditComponent } from './components/client-edit/client-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientListComponent,
    ClientAddComponent,
    ClientEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
