import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { QuestionService } from '../services/question.service';
import { GameService } from '../services/game.service';
import { User } from '../models/user';
import { Game } from '../models/game';

@Component({
    selector: 'menu',
    templateUrl: './menu.component.html',
    providers: [QuestionService, GameService],
    styleUrls: ['./menu.component.css']
})

export class MenuComponent {
    user = new User(1, "Test", "Test", null);
    userTwo = new User(2, "Test2", "Test", null);
    game = new Game(null, null, null, this.user, this.userTwo, this.userTwo, null);

    constructor(private router: Router, private questionService: QuestionService, private gameService: GameService) {

    }
    
    hide(){
        //return back-whatever()
        return true
    }

    newGame(){
        // this.router.navigate(["/opponent"]);
        // create a game
        // pick first question
        this.gameService.create(this.game);
        this.router.navigate(["/question"])
    }
}