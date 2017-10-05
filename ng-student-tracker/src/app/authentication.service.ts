import { User } from './model/user';
import { Injectable } from '@angular/core';
import { Http, Headers, Response, ResponseOptions, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class AuthenticationService {

  private token: string;

  constructor(private http: Http) { }

  public login(un: string, pw: string): Observable<boolean> {
    const user = JSON.stringify({username : un, password : pw});
    return this.http.post('http://localhost:8080/login', user)
                    .map(response => {
                      const token = response.headers.get('x-access-token');
                      if (token) {
                        localStorage.setItem('trackerToken', token.split(' ')[1]);
                      } else {
                        throw new Error('token not present in response');
                      }
                      return true;
                    })
                    .catch(this.handleError);
  }

  public isLoggedIn(): boolean {
    const cred = localStorage.getItem('trackerToken');
    if (cred) {
      return true;
    }
    return false;
  }

  public getTokenHeader(): Headers {
    if (!this.isLoggedIn()) {
      return null;
    }
    const headers = new Headers();
    headers.append('x-access-token', 'Bearer ' + localStorage.getItem('trackerToken'));

    return headers;
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }
}
