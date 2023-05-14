import {Course} from './course';

export interface Lesson {
  idLesson?: number;
  lessonName?: string;
  lessonContent?: string;
  course?: Course;
}
