import {Lesson} from './lesson';

export interface Course {
  idCourse?: number;
  courseName?: string;
  courseDescription?: string;
  thumbnail?: string;
  price?: number;
  courseDuration?: number;
  lessonSet?: Lesson[];
}
