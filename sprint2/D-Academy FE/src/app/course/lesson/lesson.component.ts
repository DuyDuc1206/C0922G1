import {Component, OnInit} from '@angular/core';
import {LessonService} from '../../service/course/lesson.service';
import {Lesson} from '../../model/lesson';
import {ActivatedRoute} from '@angular/router';
import {CourseService} from '../../service/course/course.service';
import {Course} from '../../model/course';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-lesson',
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.css']
})
export class LessonComponent implements OnInit {
  lessons: Lesson[] = [];
  lesson: Lesson = {};
  course: Course = {};
  idCourse: number;
  idLesson: number;

  constructor(private lessonService: LessonService,
              private courseService: CourseService,
              private activatedRoute: ActivatedRoute,
              private title: Title) {
  }

  ngOnInit(): void {
    this.title.setTitle('D Academy-Lesson');
    this.idCourse = +this.activatedRoute.snapshot.paramMap.get('idCourse');
    this.getAllLessons(this.idCourse);
    this.getCourse(this.idCourse);
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
    this.lessonService.getLessonById(id).subscribe(data => this.lesson = data);
  }

  getCourse(id: number) {
    this.courseService.getCourseById(id).subscribe(data => this.course = data);
  }

}
