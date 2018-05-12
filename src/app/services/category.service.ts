import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { URLS } from '../configuration/server-urls';
import { BaseService } from './base.service';

@Injectable()
export class CategoryService extends BaseService {

    constructor(private http: Http) {
        super();
    }

    getAll() {
        return this.http.get(URLS.SERVER_URL + URLS.GET_CATEGORIES)
            .toPromise()
            .then((resp) => this.extractData(resp))
            .catch((error) => { });
    }
}