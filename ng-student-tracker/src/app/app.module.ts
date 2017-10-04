import { ApplicationService } from './application.service';
import { StudentService } from './student.service';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';

import { VirtualScrollModule } from 'angular2-virtual-scroll';
import { StudentBoardComponent } from './student-board/student-board.component';
import { BoardItemComponent } from './board-item/board-item.component';
import { SideNavComponent } from './side-nav/side-nav.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    LoginComponent,
    HomeComponent,
    StudentBoardComponent,
    BoardItemComponent,
    SideNavComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    VirtualScrollModule,
    HttpModule
  ],
  providers: [
    StudentService,
    ApplicationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
