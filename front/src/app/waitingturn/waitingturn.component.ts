import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';
import { importType } from '@angular/compiler/src/output/output_ast';

@Component({
    selector: 'waitingturn',
    templateUrl: './waitingturn.component.html',
    providers: [CategoryService],
    styleUrls: ['./waitingturn.component.css']
})

export class WaitingTurnComponent {

    constructor(private router: Router, private categoryService: CategoryService) {
        
    }

    ngOnInit() {
        
    }

    return() {
        this.router.navigate(["/menu"]);
    }
}