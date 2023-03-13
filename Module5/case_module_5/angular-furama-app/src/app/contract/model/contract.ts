import {Customer} from '../../customer/model/customer';
import {Facility} from '../../facility/model/facility';
import {Employee} from '../../employee/model/employee';

export interface Contract {
  id?: number;
  startDate?: string;
  endDate?: string;
  deposit?: number;
  employee?: Employee;
  customer?: Customer;
  facility?: Facility;
}
