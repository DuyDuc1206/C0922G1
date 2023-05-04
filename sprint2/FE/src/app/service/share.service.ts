import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable, Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShareService {
  private subject = new Subject<any>();
  private behaviorSubject = new BehaviorSubject<string>('');
  currentSearch = this.behaviorSubject.asObservable();

  constructor() {
  }

  changeSearch(nameSearch: string) {
    this.behaviorSubject.next(nameSearch);
  }

  getClickEvent(): Observable<any> {
    return this.subject.asObservable();
  }

  sendClickEvent() {
    this.subject.next();
  }
}
