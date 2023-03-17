import {TypeCoach} from "./type-coach";
import {CompanyName} from "./company-name";
import {Position} from "./position";

export interface Coach {
  id?: number;
  codeCoach?: number;
  typeCoach?: TypeCoach;
  companyName?: CompanyName;
  startLocation?: Position;
  destination?: Position;
  phoneNumber?: string;
  email?: string;
  startTime?: string;
  endTime?: string;
}
