import { Question } from './question';
export class Answer {

    answerCode: number;
    isCorrect: number;
    text: string;
    question: Question;

    constructor(answerCode: number, isCorrect: number, text: string, question: Question) {
        this.answerCode = answerCode;
        this.isCorrect = isCorrect;
        this.text = text;
        this.question = question;
    }
}