import { ApplicationService } from './../application.service';
import { Application } from './../model/application';
import { Contact } from './../model/contact';
import { Address } from './../model/address';
import { User } from './../model/user';
import { Student } from './../model/student';
import { Component, OnInit } from '@angular/core';


const testApps: Application[] = [];

@Component({
  selector: 'app-student-board',
  templateUrl: './student-board.component.html',
  styleUrls: ['./student-board.component.css'],
  providers: [ ApplicationService ]
})
export class StudentBoardComponent implements OnInit {

  private applications: Application[] = [];

  constructor(private appService: ApplicationService) { }

  ngOnInit() {
    this.appService.getApplications()
      .subscribe(
        applications => {
          console.log(applications);
          this.applications = applications;
        },
        error => console.error(error)
      );
  }

}
