import { BaseService } from './base.service';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Game } from '../models/game';

@Injectable()
export class GameService extends BaseService {

    constructor(private http: Http) {
        super();
    }

    create(game: Game): any {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let body = JSON.stringify(game);
        console.log(body);
        return this.http.post("http://localhost:37000/new-game", body, { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }
}