import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Question } from '../models/question';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';
import { QuestionService } from '../services/question.service';

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
        this.question = new Question(null, new Category(null, null), null, null, null, null);
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
        this.questionService.create(this.question);
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