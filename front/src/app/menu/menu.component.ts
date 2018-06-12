import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.css']
})

export class MenuComponent {
    private router: Router
    ngOnInit() {
        console.log("hola");
    }

    hide(){
        //return back-whatever()
        return true
    }

    redirect(){
        /*if (your turn){
            this.router.navigate(['/question']);
        }else{
            this.router.navigate(['/waitingturn']);
        }*/
    }
}