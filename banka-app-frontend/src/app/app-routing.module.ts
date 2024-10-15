import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ATMComponent } from './components/atm/atm.component';
import { FilijalaComponent } from './components/filijala/filijala.component';

const routes: Routes = [
  {
    path: "login",component: LoginComponent
  },
  {
    path: "registration",component: RegistrationComponent
  },
  {
   path: "home",component:HomePageComponent
  },
  {
   path: "atm",component:ATMComponent
  },
  {
   path: "filijala",component:FilijalaComponent
  },
  {
    path:"",redirectTo:"/login",pathMatch:"full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
