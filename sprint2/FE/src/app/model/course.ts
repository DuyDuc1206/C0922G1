import {Category} from './category';

export interface Course {
  idCourse?: number;
  courseName?: string;
  courseDescription?: string;
  thumbnail?: string;
  price?: number;
  courseDuration?: number;
  category?: Category;
}
