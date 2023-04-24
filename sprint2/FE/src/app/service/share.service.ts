import {Injectable} from '@angular/core';
import {Observable, Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShareService {
  private subject = new Subject<any>();

  constructor() {
  }

  getClickEvent(): Observable<any> {
    return this.subject.asObservable();
  }
  sendClickEvent() {
    this.subject.next();
  }
}
