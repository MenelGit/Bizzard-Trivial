import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';
import { importType } from '@angular/compiler/src/output/output_ast';
import { Player } from '../models/player';

@Component({
    selector: 'social',
    templateUrl: './social.component.html',
    providers: [CategoryService],
    styleUrls: ['./social.component.css']
})

export class SocialComponent {

    constructor(private router: Router, private categoryService: CategoryService) {
        
    }

    ngOnInit() {
        
    }

    getFriends() {
        let friends = [
            new Player('Tomate', '111'),
            new Player('Tomata', '222')
          ];
        return friends;
    }

    return() {
        this.router.navigate(["/menu"]);
    }
}