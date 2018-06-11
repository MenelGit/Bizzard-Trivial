import { Response } from '@angular/http';

export class BaseService {

    constructor() {
    }
    
    public extractData(res: Response) {
        if (res) {
            return res.json();
        }
    }

    public extractDataText(res: Response) {
        if (res) {
            return res.text();
        }
    }

    public extractDataContent(res: Response) {
        if (res) {
            return res.json().content;
        }
    }
}