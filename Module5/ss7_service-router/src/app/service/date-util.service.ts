import {Injectable} from '@angular/core';
import {addMonths, addYears, differenceInDays, differenceInMonths, differenceInYears} from 'date-fns';

@Injectable({
  providedIn: 'root'
})
export class DateUtilService {

  constructor() {
  }

  getDiffNow(diff: string | number | Date): string {
    const result: string[] = [];
    const result2: string[] = [];
    const now = new Date();
    diff = new Date(diff);
    const years = differenceInYears(now, diff);
    const y = now.getFullYear() - diff.getFullYear();
    if (years > 0) {
      result.push(`${years} years`);
      diff = addYears(diff, years);
    }
    if (y > 0) {
      result2.push(`${y} years`);
    }
    const months = differenceInMonths(now, diff);
    const m = now.getMonth() - diff.getMonth();
    if (months > 0) {
      result.push(`${months} month`);
      diff = addMonths(diff, months);
    }
    if (m > 0) {
      result2.push(`${m} month`);
    }
    const days = differenceInDays(now, diff);
    const d = now.getDate() - diff.getDate();
    if (d > 0) {
      result2.push(`${d} day`);
    }
    if (days > 0) {
      result.push(`${days} day`);
    }
    return result.join(' ') + result2.join(' ');
  }

}
