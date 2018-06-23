export class QuestionsPerGamePK {

    questionCode: number;
    gameCode: number;
    userCode: number;

    constructor(questionCode: number, gameCode: number, userCode: number) {
        this.questionCode = questionCode;
        this.gameCode = gameCode;
        this.userCode = userCode;
    }
}