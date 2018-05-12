import { Injectable } from '@angular/core';

@Injectable()
export class AuthService {

    constructor() {
        
    }

    checkUser(user: string) {
        return true;
        // return false;
    }
}