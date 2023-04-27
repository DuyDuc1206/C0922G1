import {Component, OnInit} from '@angular/core';
import {CourseService} from '../service/course/course.service';
import {Course} from '../model/course';
import {ActivatedRoute} from '@angular/router';
import {Lesson} from '../model/lesson';
import {LessonService} from '../service/course/lesson.service';

@Component({
  selector: 'app-course-detail',
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css']
})
export class CourseDetailComponent implements OnInit {
  course: Course = {};
  lessons: Lesson[] = [];
  id: number;

  constructor(private courseService: CourseService,
              private lessonService: LessonService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
      this.getCourse(this.id);
      this.getAllLessons(this.id);
    });
  }

  getCourse(id: number) {
    this.courseService.getCourseById(id).subscribe(data => {
      this.course = data;
    });
  }

  getAllLessons(id: number) {
    this.lessonService.getAllLessonByCourseId(id).subscribe(data => {
      this.lessons = data;
    });
  }

}
