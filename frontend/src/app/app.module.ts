import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component'
import { LandingPageComponent } from './landing-page/landing-page.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegisterPageComponent } from './register-page/register-page.component';
import { LogincomponentComponent } from './logincomponent/logincomponent.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TokenInterceptor } from './helpers/token.interceptor';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardRedisignComponent } from './dashboard-redisign/dashboard-redisign.component';
import { LandingRedesignComponent } from './landing-redesign/landing-redesign.component';
// import { StatsComponent } from './stats/stats.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    NavbarComponent,
    LandingPageComponent,
    RegisterPageComponent,
    LogincomponentComponent,
    DashboardRedisignComponent,
    LandingRedesignComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})


export class AppModule { }
