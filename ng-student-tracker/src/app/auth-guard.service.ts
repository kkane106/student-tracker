import { AuthenticationService } from './authentication.service';
import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

@Injectable()
export class AuthGuardService implements CanActivate {

  constructor(private authService: AuthenticationService) { }

  canActivate() {
    return this.authService.isLoggedIn();
  }

}
