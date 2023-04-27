import {Component, OnInit} from '@angular/core';
import {LessonService} from '../service/course/lesson.service';
import {Lesson} from '../model/lesson';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-lesson',
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.css']
})
export class LessonComponent implements OnInit {
  lessons: Lesson[] = [];
  lesson: Lesson = {};
  idCourse: number;
  idLesson: number;

  constructor(private lessonService: LessonService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.idCourse = +this.activatedRoute.snapshot.paramMap.get('idCourse');
    this.getAllLessons(this.idCourse);
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.idLesson = +paraMap.get('idLesson');
      this.getLesson(this.idLesson);
      console.log('aaaa' + this.idLesson);
    });
  }

  getAllLessons(id: number) {
    this.lessonService.getAllLessonByCourseId(id).subscribe(data => {
      this.lessons = data;
    });
  }

  getLesson(id: number) {
    this.lessonService.getLessonById(id).subscribe(data => {
      this.lesson = data;
    });
  }

}
