import {Injectable} from '@angular/core';
import {Facility} from '../model/facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  facilityList: Facility[] = [
    {
      id: 1,
      name: 'Villa Beach Front',
      area: 25000,
      cost: 1000000,
      maxPeople: 10,
      standardRoom: 'vip',
      description: 'co ho boi',
      poolArea: 500,
      numberOfFloor: 10,
    },
    {
      id: 2,
      name: 'Villa Beach',
      area: 250,
      cost: 10000,
      maxPeople: 10,
      standardRoom: 'vip',
      description: 'co ho boi',
      poolArea: 500,
      numberOfFloor: 10,
    }
  ];

  constructor() {
  }

  findAdd(): Facility[] {
    return this.facilityList;
  }
}
