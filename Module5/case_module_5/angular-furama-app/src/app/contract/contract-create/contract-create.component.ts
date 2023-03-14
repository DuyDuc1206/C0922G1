import {Component, OnInit} from '@angular/core';
import {Contract} from '../model/contract';
import {Customer} from '../../customer/model/customer';
import {Facility} from '../../facility/model/facility';
import {ContractService} from '../service/contract.service';
import {CustomerService} from '../../customer/service/customer.service';
import {FacilityService} from '../../facility/service/facility.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  customerList: Customer[] = [];
  facilityList: Facility[] = [];
  contractCreateForm: FormGroup;

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private facilityService: FacilityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllCustomer();
    this.getAllFacility();
    this.contractCreateForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      startDate: new FormControl('', [Validators.required]),
      endDate: new FormControl('', [Validators.required]),
      customer: new FormControl('', [Validators.required]),
      facility: new FormControl('', [Validators.required]),
    });
  }

  idControl = () => this.contractCreateForm.get('id');
  startDateControl = () => this.contractCreateForm.get('startDate');
  endDateControl = () => this.contractCreateForm.get('endDate');
  customerControl = () => this.contractCreateForm.get('customer');
  facilityControl = () => this.contractCreateForm.get('facility');

  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(item => {
      this.customerList = item;
    });
  }

  getAllFacility() {
    this.facilityService.findAllFacility().subscribe(item => {
      this.facilityList = item;
    });
  }

  onSubmit() {
    this.contractService.createContract(this.contractCreateForm.value).subscribe(item => {
      this.router.navigateByUrl('/contract');
    });
  }
}
