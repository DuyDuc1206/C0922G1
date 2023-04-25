import { Component, OnInit } from '@angular/core';
import {CourseService} from '../service/course/course.service';
import {Course} from '../model/course';
@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courses: Course[] = [];

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
  }

}
