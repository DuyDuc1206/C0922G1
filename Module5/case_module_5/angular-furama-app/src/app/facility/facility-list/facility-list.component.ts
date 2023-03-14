import {Component, OnInit} from '@angular/core';
import {Facility} from '../model/facility';
import {FacilityService} from '../service/facility.service';
import {FacilityType} from '../model/facility-type';
import {RentType} from '../model/rent-type';
import {FacilityTypeService} from '../service/facility-type.service';
import {RentTypeService} from '../service/rent-type.service';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilityList: Facility[] = [];
  facilityTypeList: FacilityType[] = [];
  rentTypeList: RentType[] = [];

  constructor(private facilityService: FacilityService,
              private facilityTypeService: FacilityTypeService,
              private rentTypeService: RentTypeService) {
  }

  ngOnInit(): void {
    this.getAllFacility();
    this.getAllFacilityType();
    this.getAllRentType();
  }

  getAllFacility() {
    this.facilityService.findAllFacility().subscribe(item => {
      this.facilityList = item;
    });
  }
  getAllFacilityType() {
    this.facilityTypeService.getAllFacilityType().subscribe(item => {
      this.facilityTypeList = item;
    });
  }
  getAllRentType() {
    this.rentTypeService.getAllRentType().subscribe(item => {
      this.rentTypeList = item;
    });
  }

}
