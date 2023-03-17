import {Component, OnInit} from '@angular/core';
import {CoachService} from "../service/coach.service";
import {ToastrService} from "ngx-toastr";
import {TypeCoachService} from "../service/type-coach.service";
import {CompanyNameService} from "../service/company-name.service";
import {TypeCoach} from "../model/type-coach";
import {CompanyName} from "../model/company-name";
import {Coach} from "../model/coach";
import {Position} from "../model/position";
import {PositionService} from "../service/position.service";

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {
  typeCoachs: TypeCoach[] = []
  companyNames: CompanyName[] = [];
  coachList: Coach[] = [];
  PositionList: Position[] = [];
  item:number
  value:number

  constructor(private typeCoachService: TypeCoachService,
              private CompanyNameService: CompanyNameService,
              private coachService: CoachService,
              private toastr: ToastrService,
              private positionService: PositionService) {
  }

  ngOnInit(): void {
    this.getAllCoach();
    this.getAllCompanyName();
    this.getAllTypeCoach();
    this.getAllPosition();
  }
  delete(id:number,name:number){
    this.item = name
    this.value=id
  }
  getAllPosition(){
  this.positionService.getAll().subscribe( item => {
    this.PositionList = item;
  })
  }
  getAllCoach() {
    this.coachService.getAll().subscribe(item => {
      this.coachList = item;
    })
  }

  getAllTypeCoach() {
    this.typeCoachService.getAll().subscribe(item => {
      this.typeCoachs = item;
    })
  }

  getAllCompanyName() {
    this.CompanyNameService.getAll().subscribe(item => {
      this.companyNames = item;
    })
  }

  deleteCoach(id:number) {
    this.coachService.deleteCoach(id).subscribe(item => {
      this.getAllCoach();
      this.toastr.success("Xóa thành công");
    })
  }
}
