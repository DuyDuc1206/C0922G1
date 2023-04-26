import {Component, OnInit} from '@angular/core';
import {CourseService} from '../service/course/course.service';
import {Course} from '../model/course';
import {Lesson} from '../model/lesson';
import {LessonService} from '../service/course/lesson.service';
import {ActivatedRoute} from '@angular/router';

declare var particlesJS: any;

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courses: Course[] = [];
  lessons: Lesson[] = [];
  courseId: number;
  lessonsPerCourse: { course: Course, lessons: Lesson[], lessonCount: number }[];

  constructor(private courseService: CourseService,
              private lessonService: LessonService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    // tslint:disable-next-line:only-arrow-functions
    particlesJS.load('particles-js', 'assets/particles.json', function() {
      console.log('callback - particles.js config loaded');
    });
    this.getAllCourse();
    // this.courseId = +this.activatedRoute.snapshot.paramMap.get('courserId');
    // this.getLessonsByCourse();
    this.getAllLessons();
  }

  getAllCourse() {
    this.courseService.getALlCourse().subscribe(next => {
      this.courses = next;
      this.updateLessonsPerCourse();
    });
  }

  // getLessonsByCourse() {
  //   this.lessonService.getAllLesson(this.courseId).subscribe(next => {
  //     this.lessons = next;
  //     this.updateLessonsPerCourse();
  //   });
  // }

  updateLessonsPerCourse() {
    if (this.courses.length > 0 && this.lessons.length > 0) {
      this.lessonsPerCourse = this.courses.map((course) => ({
        course,
        lessons: this.lessons.filter((lesson) => lesson.course.idCourse === course.idCourse),
        lessonCount: this.lessons.filter((lesson) => lesson.course.idCourse === course.idCourse).length
      }));
      console.log(this.lessonsPerCourse[0].lessonCount);
    }
  }

  getAllLessons() {
    this.lessonService.getAll().subscribe(next => {
      this.lessons = next;
      this.updateLessonsPerCourse();
    });
  }

}
