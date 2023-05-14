import {User} from './user';

export interface Orders {
  idOrder?: number
  orderDate?: string
  codeOrder?: string
  user?: User
  totalPrice: number
}
