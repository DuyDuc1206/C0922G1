import {Component, OnInit} from '@angular/core';
import {Contract} from '../model/contract';
import {ContractService} from '../service/contract.service';
import {Customer} from '../../customer/model/customer';
import {Facility} from '../../facility/model/facility';
import {CustomerService} from '../../customer/service/customer.service';
import {FacilityService} from '../../facility/service/facility.service';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contractList: Contract[] = [];
  customerList: Customer[] = [];
  facilityList: Facility[] = [];

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private facilityService: FacilityService) {
  }

  ngOnInit(): void {
    this.getAllContract();
    this.getAllCustomer();
    this.getAllFacility();
  }

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

  getAllContract() {
    this.contractService.getAll().subscribe(item => {
      this.contractList = item;
    });
  }

}
