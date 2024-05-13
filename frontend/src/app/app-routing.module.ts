import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { LogincomponentComponent } from './logincomponent/logincomponent.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuard } from './helpers/auth..guard';
import { LandingRedesignComponent } from './landing-redesign/landing-redesign.component';
import { DashboardRedisignComponent } from './dashboard-redisign/dashboard-redisign.component';
// import { DashboardRedisignComponent } from './dashboard-redisign/dashboard-redisign.component';

const routes: Routes = [
      // {path: '', component:LandingRedesignComponent},
      // {path: 'register', component:RegisterPageComponent},
      // {path: 'login', component:LogincomponentComponent},
      // {path: 'dashboard', component:DashboardRedisignComponent, canActivate:[AuthGuard]},
      // {path: 'landing', component:LandingRedesignComponent}
      { path: '', redirectTo: '/landing', pathMatch: 'full' },
      { path: 'landing', component: LandingRedesignComponent },
      { path: 'dashboard', component: DashboardRedisignComponent, canActivate:[AuthGuard]},
      {path: 'register', component:RegisterPageComponent},
      {path: 'login', component:LogincomponentComponent},
      {path: 'links', component:DashboardComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
