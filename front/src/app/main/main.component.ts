import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'main',
    templateUrl: './main.component.html'
})

export class MainComponent {

    constructor(private router:Router){}

    ngOnInit() {
        console.log("main");
    }

    caca(event:any)
    {
        this.router.navigate(['/menu']);
    }
}