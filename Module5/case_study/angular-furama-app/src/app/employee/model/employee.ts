import {Division} from './division';
import {EducationDegree} from './education-degree';

export interface Employee {
  id?: number;
  name?: string;
  dateOfBirth?: string;
  idCard?: string;
  salary?: string;
  phoneNumber?: string;
  email?: string;
  address?: string;
  position?: Position;
  educationDegree?: EducationDegree;
  division?: Division;
}
