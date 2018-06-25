import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from '../models/game';
import { User } from '../models/user';
import { GameService } from '../services/game.service';
import { QuestionService } from '../services/question.service';
import { Answer } from '../models/answer';
import { AnswerService } from '../services/answer.service';
import { UserService } from '../services/user.service';

@Component({
    selector: 'question',
    templateUrl: './question.component.html',
    providers: [QuestionService, GameService, AnswerService],
    styleUrls: ['./question.component.css']
})

export class QuestionComponent {

    user = new User(4, "Test", "Test", null);
    userTwo = new User(5, "Test2", "Test", null);
    game = new Game(null, null, null, null, this.user, this.userTwo, null);
    first = true;
    gameId: number = 0;
    correctAnswer: Answer = new Answer(null, null, null, null);
    wrong1: Answer = new Answer(null, null, null, null);
    wrong2: Answer = new Answer(null, null, null, null);
    wrong3: Answer = new Answer(null, null, null, null);
    responseMessage: string = null;
    isErrorMsg: boolean = false;

    constructor(private router: Router, private gameService: GameService,
        private questionService: QuestionService, private answerService: AnswerService, private userService: UserService) {

    }

    ngOnInit() {
        this.gameService.checkGames(this.userService.user.userCode).then((res) => {
            if (res.gameCode != null) {
                this.gameId = res.gameCode;
                this.questionService.findNext(res.gameCode, this.userService.user.userCode).then((res) => {
                    document.getElementById("title").textContent = res.text;
                    this.correctAnswer = res.answers[0];
                    this.wrong1 = res.answers[1];
                    this.wrong2 = res.answers[2];
                    this.wrong3 = res.answers[3];
                }).catch((error) => {
                    this.responseMessage = "No questions found. GAME OVER";
                });
            } else {
                this.gameService.create(this.game, this.userService.user.userCode).then((res) => {
                    this.gameId = res.gameCode;
                    if (this.first == true) {
                        this.first = false;
                    } else {
                        this.first = true;
                    }
                    this.questionService.findFirst(this.userService.user.userCode).then((res) => {
                        document.getElementById("title").textContent = res.text;
                        this.correctAnswer = res.answers[0];
                        this.wrong1 = res.answers[1];
                        this.wrong2 = res.answers[2];
                        this.wrong3 = res.answers[3];
                    }).catch((error) => { });
                }).catch((error) => { });
            }
        }).catch((error) => { });
    }

    return() {
        this.router.navigate(["/menu"]);
    }

    check(answer: Answer) {
        if (this.userService.user.username != null && this.userService.user.userCode != null) {
            this.answerService.check(answer, this.gameId, this.userService.user.username).then((res) => {
                if (answer.isCorrect == 1) {
                    this.questionService.findNext(this.gameId, this.userService.user.userCode).then((res) => {
                        document.getElementById("title").textContent = res.text;
                        this.correctAnswer = res.answers[0];
                        this.wrong1 = res.answers[1];
                        this.wrong2 = res.answers[2];
                        this.wrong3 = res.answers[3];
                    }).catch((error) => {
                        this.responseMessage = "No questions found. GAME OVER";
                    });
                } else {
                    this.router.navigate(["/waitingturn"]);
                }
            }).catch((error) => {

            });
        } else {
            this.router.navigate(["/login"]);
        }
    }
}