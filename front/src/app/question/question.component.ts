import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from '../models/game';
import { User } from '../models/user';
import { GameService } from '../services/game.service';
import { QuestionService } from '../services/question.service';

@Component({
    selector: 'question',
    templateUrl: './question.component.html',
    providers: [QuestionService, GameService],
    styleUrls: ['./question.component.css']
})

export class QuestionComponent {

    user = new User(4, "Test", "Test", null);
    userTwo = new User(5, "Test2", "Test", null);
    game = new Game(null, null, this.user, this.user, this.user, this.userTwo, null);

    constructor(private router: Router, private gameService: GameService) {
        
    }

    ngOnInit() {
        console.log("hola");
        this.gameService.create(this.game).then((res) => {
            console.log("bien");
        }).catch((error) => {
            console.log("mal");
        });
    }

    return() {
        this.router.navigate(["/menu"]);
    }
}