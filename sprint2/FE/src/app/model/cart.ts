import {Course} from './course';
import {User} from './user';

export interface Cart {
  id?: number;
  course?: Course;
  user?: User;
  quantity?: number;
}
