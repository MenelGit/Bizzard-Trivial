import { BaseService } from './base.service';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Game } from '../models/game';

@Injectable()
export class GameService extends BaseService {

    constructor(private http: Http) {
        super();
    }

    create(game: Game, userCode: number): any {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let body = JSON.stringify(game);
        return this.http.post("http://localhost:37000/new-game?userCode=" + userCode, body, { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { return Promise.reject(this.handleError(error))});
    }

    checkGames(userCode: number): any {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        return this.http.get("http://localhost:37000/check-game?userCode=" + userCode, { headers: headers })
            .toPromise()
            .then((res) => { return this.extractData(res);})
            .catch((error) => { console.log(error); return Promise.reject(this.handleError(error))});
    }
}