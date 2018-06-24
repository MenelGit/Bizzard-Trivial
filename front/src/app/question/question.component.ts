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

    user = new User(1, "Test", "Test", null);
    userTwo = new User(2, "Test2", "Test", null);
    game = new Game(null, null, this.user, this.user, this.user, this.userTwo, null);
    first = true;
    gameId: number;

    constructor(private router: Router, private gameService: GameService, private questionService: QuestionService) {
        
    }

    ngOnInit() {
        console.log("hola");
        this.gameService.create(this.game).then((res) => {
            console.log("bien");
            this.gameId = res.gameCode;
            if(this.first == true){
                this.first = false;
                console.log(this.first);
                
            }else{
                this.first = true;
            }
            
        }).catch((error) => {
            console.log("mal");
        });
        this.questionService.getAll().then((res) => {
            document.getElementById("title").textContent = res.text;
            document.getElementById("one").textContent = res.answers[0];
            document.getElementById("two").textContent = res.answers[1];
            document.getElementById("three").textContent = res.answers[2];
            document.getElementById("four").textContent = res.answers[3];
        })
    }

    return() {
        this.router.navigate(["/menu"]);
    }
}