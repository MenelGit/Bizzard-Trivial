import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Router } from '@angular/router';
import { Category } from '../models/category';
import { BaseService } from './base.service';
import { Answer } from '../models/answer';

@Injectable()
export class AnswerService extends BaseService {

    constructor(private http: Http) {
        super();
    }

    check(answer: Answer, gameCode: number, userName: string): any {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let body = JSON.stringify(answer);
        return this.http.post("http://localhost:37000/check?gameCode=" + gameCode + "&userName=" + userName, body, { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }
}