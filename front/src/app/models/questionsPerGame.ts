import { User } from "./user";
import { Game } from "./game";
import { Question } from "./question";
import { QuestionsPerGamePK } from "./questionsPerGamePK";

export class QuestionsPerGame {

    id: QuestionsPerGamePK;
    isCorrect: number;
    isPlayed: number;
    game: Game;
    question: Question;
    user: User;
    // questionsPerGames: Array;

    constructor(id: QuestionsPerGamePK, isCorrect: number, isPlayed: number, game: Game, question: Question, user: User) {
        this.id = id;
        this.isCorrect = isCorrect;
        this.isPlayed = isPlayed;
        this.game = game;
        this.question = question;
        this.user = user;
        // this.questionsPerGames = questionsPerGames;
    }
}