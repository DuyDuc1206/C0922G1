import {CustomerType} from "./customer-type";

export interface Customer {
  id?: number;
  name?: string;
  birthday?: string;
  gender?: boolean;
  import?: string;
  export?: string;
  phoneNumber?: string;
  email?: string;
  customerType?: CustomerType;
}
