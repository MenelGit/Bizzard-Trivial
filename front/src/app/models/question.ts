import { Category } from "./category";

export class Question {

    question: string;
    category: Category;
    correctAnswer: string;
    wrongAnswer1: string;
    wrongAnswer2: string;
    wrongAnswer3: string;

    constructor(question: string, category: Category, correctAnswer: string, wrongAnswer1: string, wrongAnswer2: string, wrongAnswer3: string) {
        this.question = question;
        this.category = category;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
    }
}