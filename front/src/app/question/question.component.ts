import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';
import { importType } from '@angular/compiler/src/output/output_ast';

@Component({
    selector: 'question',
    templateUrl: './question.component.html',
    providers: [CategoryService],
    styleUrls: ['./question.component.css']
})

export class QuestionComponent {

    constructor(private router: Router, private categoryService: CategoryService) {
        
    }

    ngOnInit() {
        
    }

    return() {
        this.router.navigate(["/menu"]);
    }
}