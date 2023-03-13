import {Component, OnInit} from '@angular/core';
import {DictionaryService} from '../service/dictionary.service';
import {IWord} from '../iword';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word: IWord;

  constructor(private dictionaryService: DictionaryService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paraMap => {
      const word = paraMap.get('word');
      this.word = this.dictionaryService.findByWord(word);
    });
  }
}
