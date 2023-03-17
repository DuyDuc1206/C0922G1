import {Component, OnInit} from '@angular/core';

import {ActivatedRoute, Router} from "@angular/router";

import {CoachService} from "../service/coach.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

import {ToastrService} from "ngx-toastr";
import {CompanyNameService} from "../service/company-name.service";
import {CompanyName} from "../model/company-name";
import {TypeCoachService} from "../service/type-coach.service";
import {TypeCoach} from "../model/type-coach";
import {Position} from "../model/position";
import {PositionService} from "../service/position.service";


@Component({
  selector: 'app-car-edit',
  templateUrl: './car-edit.component.html',
  styleUrls: ['./car-edit.component.css']
})
export class CarEditComponent implements OnInit {
  typeCoachs: TypeCoach[] = []
  companyNames: CompanyName[] = [];
  positionList: Position[] = [];
  id: number;
  editForm: FormGroup;

  constructor(private typeCoachService: TypeCoachService,
              private companyNameService: CompanyNameService,
              private positionService: PositionService,
              private activatedRoute: ActivatedRoute,
              private coachService: CoachService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllCompanyName();
    this.getAllPosition();
    this.getAllTypeCoach();
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = +paramMap.get('id');
      this.getCar(this.id);
    })
  }

  getAllPosition() {
    this.positionService.getAll().subscribe(item => {
      this.positionList = item;
    })
  }

  getAllCompanyName() {
    this.companyNameService.getAll().subscribe(item => {
      this.companyNames = item;
    })
  }

  getAllTypeCoach() {
    this.typeCoachService.getAll().subscribe(item => {
      this.typeCoachs = item;
    })
  }

  getCar(id: number) {
    this.coachService.getById(id).subscribe(item => {
      this.editForm = new FormGroup({
        id: new FormControl(),
        codeCoach: new FormControl(item.codeCoach),
        typeCoach: new FormControl(this.typeCoachs.find(a => a.id === item.id), [Validators.required]),
        companyName: new FormControl(this.companyNames.find(a => a.id === item.id), [Validators.required]),
        startLocal: new FormControl(this.positionList.find(a => a.id === item.id), [Validators.required]),
        endLocal: new FormControl(this.positionList.find(a => a.id === item.id), [Validators.required]),
        phoneNumber: new FormControl(item.phoneNumber, [Validators.required]),
        email: new FormControl(item.email, [Validators.required, Validators.email]),
        startTime: new FormControl(item.startTime, [Validators.required]),
        endTime: new FormControl(item.endTime, [Validators.required]),
      })
    })
  }

  typeCoachControl = () => this.editForm.get('typeCoach');
  companyNameControl = () => this.editForm.get('companyName');
  startLocalControl = () => this.editForm.get('startLocal');
  endLocalControl = () => this.editForm.get('endLocal');
  phoneNumberControl = () => this.editForm.get('phoneNumber');
  emailControl = () => this.editForm.get('email');
  startTimeControl = () => this.editForm.get('startTime');
  endTimeControl = () => this.editForm.get('endTime');

  onSubmit() {
    this.coachService.editCoach(this.id, this.editForm.value).subscribe(item => {
      this.router.navigateByUrl('/car');
      this.toastr.success("Edit Successfully");
    })
  }
}
