import { Category } from "./category";
import { Answer } from "./answer";

export class Question {

    questionCode: number;
    text: string;
    category: Category;
    answers: Answer[];
    questionsPerGames: any;

    constructor(questionCode: number, text: string, category: Category, answers: Answer[], questionsPerGames: any) {
        this.questionCode = questionCode;
        this.text = text;
        this.category = category;
        this.answers = answers;
        this.questionsPerGames = questionsPerGames;
    }
}