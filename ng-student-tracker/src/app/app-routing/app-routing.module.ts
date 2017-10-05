import { AuthGuardService } from './../auth-guard.service';
import { StudentBoardComponent } from './../student-board/student-board.component';
import { LoginComponent } from './../login/login.component';
import { HomeComponent } from './../home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CommonModule } from '@angular/common';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home'
    // redirectTo: '' // pathMatch means match completely
  },
  {
    path: 'login',
    pathMatch: 'full',
    component: LoginComponent
  },
  {
    path: 'home',
    pathMatch: 'full',
    component: HomeComponent
  },
  {
    path: 'board',
    pathMatch: 'full',
    canActivate : [AuthGuardService],
    component: StudentBoardComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  providers : [
    AuthGuardService
  ],
  exports : [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
