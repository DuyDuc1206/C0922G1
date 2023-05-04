import {Component, OnInit} from '@angular/core';
import {CourseService} from '../../service/course/course.service';
import {LessonService} from '../../service/course/lesson.service';
import {Course} from '../../model/course';
import {Lesson} from '../../model/lesson';
import {Title} from '@angular/platform-browser';
import {NavigationEnd, Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  courses: Course[] = [];
  lessons: Lesson[] = [];
  nameSearch: string = '';
  page: number = 0;
  size: number = 6;
  lessonsPerCourse: { course: Course, lessons: Lesson[], lessonCount: number }[];

  constructor(private courseService: CourseService,
              private lessonService: LessonService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        window.scrollTo({
          top: 0,
          behavior: 'auto',
        });
      }
    });
    this.getAllCourse(this.nameSearch, this.page, this.size);
    this.updateLessonsPerCourse();
    this.getAllLesson();
  }

  getAllCourse(nameSearch: string, page: number, size: number) {
    this.courseService.getALlCourse(nameSearch, page, size).subscribe(data => {
      this.courses = data['content'];
      this.updateLessonsPerCourse();
    });
  }

  updateLessonsPerCourse() {
    if (this.courses.length > 0 && this.lessons.length > 0) {
      this.lessonsPerCourse = this.courses.map((course) => ({
        course,
        lessons: this.lessons.filter((lessons) => lessons.course.idCourse === course.idCourse),
        lessonCount: this.lessons.filter((lessons) => lessons.course.idCourse === course.idCourse).length
      }));
      console.log(this.lessonsPerCourse[0].lessonCount);
    }
  }

  getAllLesson() {
    this.lessonService.getAll().subscribe(data => {
      this.lessons = data;
      this.updateLessonsPerCourse();
    });
  }
}
