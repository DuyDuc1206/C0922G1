import {Component, OnDestroy, OnInit} from '@angular/core';
import {CourseService} from '../../service/course/course.service';
import {Course} from '../../model/course';
import {Lesson} from '../../model/lesson';
import {LessonService} from '../../service/course/lesson.service';
import {ActivatedRoute} from '@angular/router';
import {ShareService} from '../../service/share.service';
import {Subscription} from 'rxjs';
import Swal from "sweetalert2";
import {Title} from '@angular/platform-browser';

declare var particlesJS: any;

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courses: Course[] = [];
  lessons: Lesson[] = [];
  page: number = 0;
  totalPage: number = 0;
  size: number = 6;
  nameSearch: string = '';
  lessonsPerCourse: { course: Course, lessons: Lesson[], lessonCount: number }[];

  constructor(private courseService: CourseService,
              private lessonService: LessonService,
              private activatedRoute: ActivatedRoute,
              private shareService: ShareService,
              private title:Title) {
    this.shareService.currentSearch.subscribe(search => {
      this.nameSearch = search;
      this.getAllCourse(this.nameSearch, this.page, this.size);
    });
    this.getAllCourse(this.nameSearch, this.page, this.size);
  }

  ngOnInit(): void {
    this.title.setTitle('D Academy-Course')
    // tslint:disable-next-line:only-arrow-functions
    particlesJS.load('particles-js', 'assets/particles.json', function() {
      console.log('callback - particles.js config loaded');
    });
    this.getAllLessons();

  }

  getAllCourse(nameSearch: string, page: number, size: number) {
    this.courseService.getALlCourse(nameSearch, page, size).subscribe(data => {
      if (data.length==0){
        Swal.fire({
          position: 'center',
          icon: 'warning',
          title: 'Not Found!',
          showConfirmButton: false,
          timer: 3000
        });
      }else {
        this.courses = data['content'];
        this.totalPage = data['totalPages'];
        this.page = data['number'];
        this.size = data['size'];
        this.updateLessonsPerCourse();
      }

    });
  }

  updateLessonsPerCourse() {
    if (this.courses.length > 0 && this.lessons.length > 0) {
      this.lessonsPerCourse = this.courses.map((course) => ({
        course,
        lessons: this.lessons.filter(lesson => lesson.course.idCourse === course.idCourse),
        lessonCount: this.lessons.filter(lesson => lesson.course.idCourse === course.idCourse).length
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

  previousPage() {
    if (this.page > 0) {
      this.page--;
      this.getAllCourse(this.nameSearch, this.page, this.size);
    }
  }

  nextPage() {
    window.scrollTo(700,200)
    if (this.page < this.totalPage - 1) {
      this.page++;
      this.getAllCourse(this.nameSearch, this.page, this.size);
    }
  }
}
