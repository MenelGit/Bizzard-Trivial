import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';
import { importType } from '@angular/compiler/src/output/output_ast';
import { Player } from '../models/player';

@Component({
    selector: 'ranking',
    templateUrl: './ranking.component.html',
    providers: [CategoryService],
    styleUrls: ['./ranking.component.css']
})

export class RankingComponent {

    constructor(private router: Router, private categoryService: CategoryService) {
        
    }

    ngOnInit() {
        
    }

    loadRanking() {
        let players = [
            new Player('Player1', '100'),
            new Player('Player2', '50')
          ];
        return players;
    }

    return() {
        this.router.navigate(["/menu"]);
    }
}