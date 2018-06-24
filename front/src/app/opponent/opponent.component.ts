import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { importType } from '@angular/compiler/src/output/output_ast';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../models/user'
import { UserService } from '../services/user.service';

@Component({
    selector: 'opponent',
    templateUrl: './opponent.component.html',
    providers: [UserService],
    styleUrls: ['./opponent.component.css']
})

export class OpponentComponent {

    opponentForm: FormGroup;
    responseMessage: string = null;
    isErrorMsg: boolean = false;
    user: User;

    constructor(private router: Router, private userService: UserService) {
        
    }

    ngOnInit() {
        this.newUser()
        this.opponentForm = new FormGroup({
            user: new FormControl('', [Validators.required]),
            pass: new FormControl('', [Validators.required]),
        });
    }

    return() {
        this.router.navigate(["/menu"]);
    }

    newUser() {
        this.user = new User(null, null, null, null);
    }

    submit(){
        this.userService.login(this.user).then((res) => {
            this.router.navigate(['/menu']);
        }).catch((error) => {
            this.responseMessage = error;
            this.isErrorMsg = true;
        });
    }
}