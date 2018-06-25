import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './models/user';
import { CommunicationService } from './services/communication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'app';
  identified: boolean = false;
  user: User = new User(null, null, null, null);
  private subscription: any;

  constructor(private router: Router, private comService: CommunicationService) {

  }

  ngOnInit() {
    this.subscription = this.comService.source.subscribe((item: any) => { this.user = item; });
  }

  toSignUp(){
    this.router.navigate(['/signup']);
  }

  toLogin(){
    this.router.navigate(['/login']);
  }

}
