import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class CommunicationService {
    
    private src = new Subject<any>();
    private dst = new Subject<any>();

    source = this.src.asObservable();
    destination = this.dst.asObservable();

    emit(data: any) {
        this.src.next(data);
    }
}