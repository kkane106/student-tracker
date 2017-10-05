import { AuthenticationService } from './../authentication.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthenticationService) { }

  login(form: NgForm) {
    this.authService.login(form.value.username, form.value.password)
                    .subscribe(
                      res => console.log(res),
                      error => console.log(error)
                    );
  }

  ngOnInit() {
  }

}
