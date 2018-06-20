import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Question } from '../models/question';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';
import { QuestionService } from '../services/question.service';
import { Answer } from '../models/answer';

@Component({
    selector: 'newquestion',
    templateUrl: './newquestion.component.html',
    providers: [QuestionService, CategoryService],
    styleUrls: ['./newquestion.component.css']
})

export class NewQuestionComponent {

    questionForm: FormGroup;
    question: Question;
    dropdownCategories: Category[] = [];
    responseMessage: string = null;
    isErrorMsg: boolean = false;

    constructor(private router: Router, private questionService: QuestionService, private categoryService: CategoryService) {

    }

    ngOnInit() {
        this.newQuestion();
        this.questionForm = new FormGroup({
            question: new FormControl('', [Validators.required]),
            category: new FormControl('', [Validators.required]),
            correct: new FormControl('', [Validators.required]),
            wrong1: new FormControl('', [Validators.required]),
            wrong2: new FormControl('', [Validators.required]),
            wrong3: new FormControl('', [Validators.required])
        });
        this.loadCategories();
    }

    newQuestion() {
        this.question = new Question(null, null, new Category(null, null), [new Answer(null, null, null, new Question(null, null, null, null, null))], null);
    }

    loadCategories() {
        this.categoryService.getAll().then((res) => {
            this.dropdownCategories = res;
        }).catch((error) => {
            this.responseMessage = error;
            this.isErrorMsg = true;
        });
    }

    submit() {
        this.question.text = this.questionForm.value.question;
        this.question.category.codBlizzardGame = this.questionForm.value.category;
        let answers: Answer[] = [];
        answers.push(new Answer(null, 1, this.questionForm.value.correct, null));
        answers.push(new Answer(null, 0, this.questionForm.value.wrong1, null));
        answers.push(new Answer(null, 0, this.questionForm.value.wrong2, null));
        answers.push(new Answer(null, 0, this.questionForm.value.wrong3, null));
        this.question.answers = answers;
        this.questionService.create(this.question).then((res) => {
            this.responseMessage = "Pregunta creada con éxito";
        }).catch((error) => {
            this.responseMessage = error;
        });
    }

    resetForm() {
        this.questionForm.reset();
    }

    return() {
        this.router.navigate(["/menu"]);
    }

    handleResponseMsgUpdated(event) {
        this.responseMessage = event.msg;
        this.isErrorMsg = event.error;
    }
}