import { BaseService } from './base.service';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Question } from '../models/question';

@Injectable()
export class QuestionService extends BaseService {

    constructor(private http: Http) {
        super();
    }

    create(question: Question): any {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let body = JSON.stringify(question);
        return this.http.post("http://localhost:37000/new-question", body, { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }

    findFirst(userCode: number): any{
        let headers = new Headers({ 'Content-Type': 'application/json' });
        return this.http.get("http://localhost:37000/questions?userCode=" + userCode, { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }

    findNext(gameCode: number, userCode: number): any{
        let headers = new Headers({ 'Content-Type': 'application/json' });
        return this.http.get("http://localhost:37000/next-question?gameCode=" + gameCode + "&userCode=" + userCode, { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }
}