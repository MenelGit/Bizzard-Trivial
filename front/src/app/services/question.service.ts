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

    getAll(): any{
        let headers = new Headers({ 'Content-Type': 'application/json' });
        return this.http.post("http://localhost:37000/getAll", { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }
}