import { User } from "./user";
import { QuestionsPerGame } from "./questionsPerGame";

export class Game {

    gameCode: number;
    current_player: number;
    winnerUser: User;
    loserUser: User;
    playerOne: User;
    playerTwo: User;
    questionsPerGames: QuestionsPerGame[];

    constructor(gameCode: number, current_player: number, winnerUser: User, loserUser: User, playerOne: User, playerTwo: User, questionsPerGames: QuestionsPerGame[]) {
        this.gameCode = gameCode;
        this.current_player = current_player;
        this.winnerUser = winnerUser;
        this.loserUser = loserUser;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.questionsPerGames = questionsPerGames;
    }
}