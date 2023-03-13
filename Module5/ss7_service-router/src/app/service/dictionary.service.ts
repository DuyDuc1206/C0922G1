import {Injectable} from '@angular/core';
import {IWord} from '../iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  word: IWord[] = [
    {word: 'soccer', mean: 'bóng đá'},
    {word: 'badminton', mean: 'cầu lông'},
    {word: 'volleyball', mean: 'bóng chuyền'},
  ];

  constructor() {
  }

  findAll(): IWord[] {
    return this.word;
  }

  findByWord(word: string): IWord {
    return this.word.find(item => item.word === word);
  }
}
