import {CustomerType} from './customer-type';

export interface Customer {
  id?: number;
  name?: string;
  dateOfBirth?: string;
  idCard?: string;
  phoneNumber?: string;
  address?: string;
  email?: string;
  customerType?: CustomerType;
}
