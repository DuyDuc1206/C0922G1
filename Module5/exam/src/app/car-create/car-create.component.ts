import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TypeCoachService} from "../service/type-coach.service";
import {CompanyNameService} from "../service/company-name.service";
import {PositionService} from "../service/position.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CoachService} from "../service/coach.service";
import {ToastrService} from "ngx-toastr";
import {TypeCoach} from "../model/type-coach";
import {CompanyName} from "../model/company-name";
import {Position} from "../model/position";

@Component({
  selector: 'app-car-create',
  templateUrl: './car-create.component.html',
  styleUrls: ['./car-create.component.css']
})
export class CarCreateComponent implements OnInit {
  createForm: FormGroup;
  typeCoachs: TypeCoach[] = []
  companyNames: CompanyName[] = [];
  positionList: Position[] = [];

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
    this.createForm = new FormGroup({
      id: new FormControl(),
      code: new FormControl('', [Validators.required]),
      typeCoach: new FormControl('', [Validators.required]),
      companyName: new FormControl('', [Validators.required]),
      startLocation: new FormControl('', [Validators.required]),
      destination: new FormControl('', [Validators.required]),
      phoneNumber: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      startTime: new FormControl('', [Validators.required]),
      endTime: new FormControl('', [Validators.required]),
    })
  }

  codeCoachControl = () => this.createForm.get('code');
  typeCoachControl = () => this.createForm.get('typeCoach');
  companyNameControl = () => this.createForm.get('companyName');
  startLocalControl = () => this.createForm.get('startLocation');
  endLocalControl = () => this.createForm.get('destination');
  phoneNumberControl = () => this.createForm.get('phoneNumber');
  emailControl = () => this.createForm.get('email');
  startTimeControl = () => this.createForm.get('startTime');
  endTimeControl = () => this.createForm.get('endTime');

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

  onSubmit() {
    this.coachService.create(this.createForm.value).subscribe(item => {
      this.router.navigateByUrl('/coach');
      this.toastr.success("Create Successfully");
    })
  }
}
