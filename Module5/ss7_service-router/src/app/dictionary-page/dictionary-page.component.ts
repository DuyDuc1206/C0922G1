import {Component, OnInit} from '@angular/core';
import {DictionaryService} from '../service/dictionary.service';
import {IWord} from '../iword';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  word: IWord[] = [];

  constructor(private dictionaryService: DictionaryService) {
  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.word = this.dictionaryService.findAll();
  }

}
