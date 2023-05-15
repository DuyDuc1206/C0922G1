import {Component, OnInit} from '@angular/core';
import {RentType} from '../model/rent-type';
import {FacilityType} from '../model/facility-type';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../customer/service/customer.service';
import {Router} from '@angular/router';
import {CustomerTypeService} from '../../customer/service/customer-type.service';
import {FacilityService} from '../service/facility.service';
import {FacilityTypeService} from '../service/facility-type.service';
import {RentTypeService} from '../service/rent-type.service';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {
  rentTypeList: RentType[] = [];
  facilityTypeList: FacilityType[] = [];
  facilityCreateForm: FormGroup;

  constructor(private facilityService: FacilityService,
              private router: Router,
              private facilityTypeService: FacilityTypeService,
              private rentTypeService: RentTypeService) {
  }

  ngOnInit(): void {
    this.getAllFacilityType();
    this.getAllRentType();
    this.facilityCreateForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      area: new FormControl('', [Validators.required]),
      cost: new FormControl('', [Validators.required]),
      maxPeople: new FormControl('', [Validators.required]),
      standardRoom: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      poolArea: new FormControl('', [Validators.required]),
      numberOfFloor: new FormControl('', [Validators.required]),
      facilityFree: new FormControl('', [Validators.required]),
      facilityType: new FormControl('', [Validators.required]),
      rentType: new FormControl('', [Validators.required]),
    });
  }

  idControl = () => this.facilityCreateForm.get('id');
  nameControl = () => this.facilityCreateForm.get('name');
  areaControl = () => this.facilityCreateForm.get('area');
  costControl = () => this.facilityCreateForm.get('cost');
  maxPeopleControl = () => this.facilityCreateForm.get('maxPeople');
  standardRoomControl = () => this.facilityCreateForm.get('standardRoom');
  descriptionControl = () => this.facilityCreateForm.get('description');
  poolAreaControl = () => this.facilityCreateForm.get('poolArea');
  numberOfFloorControl = () => this.facilityCreateForm.get('numberOfFloor');
  facilityFreeControl = () => this.facilityCreateForm.get('facilityFree');
  facilityTypeControl = () => this.facilityCreateForm.get('facilityType');
  rentTypeControl = () => this.facilityCreateForm.get('rentType');

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

  onSubmit() {
    this.facilityService.createFacility(this.facilityCreateForm.value).subscribe(item => {
      this.router.navigateByUrl('/facility');
    });
  }
}
