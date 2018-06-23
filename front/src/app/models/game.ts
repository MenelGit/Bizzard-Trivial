import { User } from "./user";
import { QuestionsPerGame } from "./questionsPerGame";

export class Game {

    gameCode: number;
    currentUser: number;
    user1: User;
    user2: User;
    user3: User;
    user4: User;
    questionsPerGames: QuestionsPerGame[];

    constructor(gameCode: number, currentUser: number, user1: User, user2: User, user3: User, user4: User, questionsPerGames: QuestionsPerGame[]) {
        this.gameCode = gameCode;
        this.currentUser = this.currentUser;
        this.user1 = user1;
        this.user2 = user2;
        this.user3 = user3;
        this.user4 = user4;
        this.questionsPerGames = questionsPerGames;
    }
}