import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { Category } from '../models/category';

@Injectable()
export class CategoryService {

    categories: Category[] = [];

    constructor() {
        
    }

    getAll() {
        this.categories = [
            { id: 1, description: 'Warcraft' },
            { id: 2, description: 'Starcraft' },
            { id: 3, description: 'Diablo' },
            { id: 4, description: 'Hearthstone' },
            { id: 5, description: 'Heroes of the Storm' },
            { id: 6, description: 'Overwatch' }
          ];
        return this.categories;        
    }
}