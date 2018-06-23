import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'app';
  identified: boolean = false;

  constructor(private router: Router) {

  }

  toSignUp(){
    this.router.navigate(['/signup']);
  }

  toLogin(){
    this.router.navigate(['/login']);
  }

}
