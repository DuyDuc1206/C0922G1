import {Component, OnInit} from '@angular/core';
import {DateUtilService} from '../service/date-util.service';

@Component({
  selector: 'app-timelines',
  templateUrl: './timelines.component.html',
  styleUrls: ['./timelines.component.css']
})
export class TimelinesComponent implements OnInit {
  output = '';
  output2 = '';

  constructor(private dateUtilService: DateUtilService) {
  }

  ngOnInit(): void {
  }

  onchange(value: string) {
    this.output = this.dateUtilService.getDiffNow(value);
  }

  onchange2(value: string) {
    this.output2 = this.dateUtilService.getDiffNow(value);
  }
}
