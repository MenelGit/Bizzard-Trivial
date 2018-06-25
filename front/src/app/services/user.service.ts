import { BaseService } from './base.service';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Question } from '../models/question';
import { User } from '../models/user';

@Injectable()
export class UserService extends BaseService {

    user: User = new User(null, null, null, null);

    constructor(private http: Http) {
        super();
    }

    login(user: User): any {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let body = JSON.stringify(user);
        return this.http.post("http://localhost:37000/login", body, { headers: headers })
            .toPromise()
            .then((res) => { this.user = this.extractData(res); return this.user;})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }

    register(user: User): any {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let body = JSON.stringify(user);
        return this.http.post("http://localhost:37000/register", body, { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }

    getRanking(): any {
        return this.http.get("http://localhost:37000/ranking")
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }
}