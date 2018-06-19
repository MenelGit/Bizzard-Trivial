import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { Category } from '../models/category';
import { BaseService } from './base.service';

@Injectable()
export class CategoryService extends BaseService {

    categories: Category[] = [];

    constructor(private http: Http) {
        super();
    }

    getAll(): any {
        return this.http.get("http://localhost:37000/categories").toPromise()
            .then((res) => {
                this.extractData(res);
            }).catch(() => { });
    }
}