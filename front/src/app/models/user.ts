export class User {

    userCode: number;
    password: string;
    username: string;
    questionsPerGames: any;

    constructor(userCode: number, password: string, username: string, questionsPerGames: any) {
        this.userCode = userCode;
        this.password = password;
        this.username = username;
        this.questionsPerGames = questionsPerGames;
    }
}