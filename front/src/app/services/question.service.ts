import { Injectable } from '@angular/core';
import { Question } from '../models/question';

@Injectable()
export class QuestionService {

    constructor() {
        
    }

    create(question: Question) {
        console.log("HAY QUE LLAMAR AL BACK. ME LLEGA -> " + JSON.stringify(question));
    }
}