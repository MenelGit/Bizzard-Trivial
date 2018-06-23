import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { GameService } from '../services/game.service';
import { QuestionService } from '../services/question.service';

@Component({
    selector: 'menu',
    templateUrl: './menu.component.html',
    providers: [],
    styleUrls: ['./menu.component.css']
})

export class MenuComponent {

    constructor(private router: Router) {

    }
    
    hide(){
        //return back-whatever()
        return true;
    }
}