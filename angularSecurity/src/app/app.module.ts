import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponentComponent } from './components/register-component/register-component.component';
import {FormsModule} from "@angular/forms";
import { LoginComponentComponent } from './components/login-component/login-component.component';
import {HttpClientModule} from '@angular/common/http';
import { HelloComponent } from './components/hello/hello.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponentComponent,
    LoginComponentComponent,
    HelloComponent
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
