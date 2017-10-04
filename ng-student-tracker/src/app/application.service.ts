import { Application } from './model/application';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';

@Injectable()
export class ApplicationService {

  constructor(private http: Http) { }

  getApplications(): Observable<Application[]> {
    return this.http
                  .get('http://localhost:8080/applications')
                  .map(response => response.json())
                  .do(data => console.log(data))
                  .catch(this.handleError);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json() || 'Server error');
  }
}
