import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { importType } from '@angular/compiler/src/output/output_ast';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    providers: [],
    styleUrls: ['./login.component.css']
})

export class LoginComponent {

    loginForm: FormGroup;
    responseMessage: string = null;
    isErrorMsg: boolean = false;

    constructor(private router: Router,) {
        
    }

    ngOnInit() {
        this.loginForm = new FormGroup({
            user: new FormControl('', [Validators.required]),
            pass: new FormControl('', [Validators.required]),
        });
    }

    return() {
        this.router.navigate(["/menu"]);
    }
}