import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../models/category';
import { CategoryService } from '../services/category.service';
import { importType } from '@angular/compiler/src/output/output_ast';
import { Player } from '../models/player';
import { UserService } from '../services/user.service';

@Component({
    selector: 'ranking',
    templateUrl: './ranking.component.html',
    providers: [UserService],
    styleUrls: ['./ranking.component.css']
})

export class RankingComponent {

    ranking: any;

    constructor(private router: Router, private userService: UserService) {
        
    }

    ngOnInit() {
        this.userService.getRanking().then((res) => {
            console.log(res);
            this.ranking = res;
        }).catch((error) => {
        });
    }

    loadRanking() {
        
    }

    return() {
        this.router.navigate(["/menu"]);
    }
}