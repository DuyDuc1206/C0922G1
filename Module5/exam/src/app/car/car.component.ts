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
  positionList: Position[] = [];
  selectTypeCoach: string = '';
  item: string;
  value: number;
  page: number = 0;
  totalPage: number = 0;
  size: number = 0;
  codeSearch: string = '';

  constructor(private typeCoachService: TypeCoachService,
              private CompanyNameService: CompanyNameService,
              private coachService: CoachService,
              private toastr: ToastrService,
              private positionService: PositionService) {
  }

  ngOnInit(): void {
    this.getAllCoach(this.page, this.codeSearch, this.selectTypeCoach);
    this.getAllCompanyName();
    this.getAllTypeCoach();
    this.getAllPosition();
    this.searchAll();
  }

  delete(id: number, name: string) {
    this.item = name
    this.value = id
  }

  getAllPosition() {
    this.positionService.getAll().subscribe(item => {
      this.positionList = item;
    })
  }

  getAllCoach(page: number, code: string, typeCoach: string) {
    this.coachService.getAll(page, code, typeCoach).subscribe(item => {
      this.coachList = item['content'];
      this.totalPage = item['totalPages'];
      this.page = item['number'];
      this.size = item['size'];
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

  deleteCoach(id: number) {
    this.coachService.deleteCoach(id).subscribe(item => {
      this.getAllCoach(this.page, this.codeSearch, this.selectTypeCoach);
      this.toastr.success("Xóa thành công");
    })
  }

  previousPage() {
    if (this.page > 0) {
      this.page--;
      this.getAllCoach(this.page, this.codeSearch, this.selectTypeCoach);
    }
  }

  nextPage() {
    if (this.page < this.totalPage - 1) {
      this.page++;
      this.getAllCoach(this.page, this.codeSearch, this.selectTypeCoach);
    }
  }

  searchAll() {
    this.coachService.getAll(this.page, this.codeSearch, this.selectTypeCoach).subscribe(item => {
      if (item) {
        this.coachList = item['content'];
        this.totalPage = item['totalPages'];
        this.page = item['number'];
        this.size = item['size'];
      } else {
        this.coachList = [];
        this.totalPage = 0;
        this.page = 0;
        this.size = 0;
      }
    })
  }
}

