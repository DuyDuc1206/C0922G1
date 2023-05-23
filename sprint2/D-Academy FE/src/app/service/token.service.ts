import {Injectable} from '@angular/core';
import {Cart} from '../model/cart';

const TOKEN_KEY = 'Token_Key';
const ID_KEY = 'Id_key';
const NAME_KEY = 'Name_Key';
const ROLE_KEY = 'Role_key';
const STORAGE = 'Storage_key';
const CART = 'Cart_key';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  username: string;
  cart: Cart[] = [];

  constructor() {
  }

  isLogined() {
    return !!this.getToken();
  }

  signOut() {
    window.location.reload();
    window.sessionStorage.clear();
  }

  public setStorage(storage: string) {
    localStorage.removeItem(STORAGE);
    localStorage.setItem(STORAGE, storage);
    sessionStorage.removeItem(STORAGE);
    sessionStorage.setItem(STORAGE, storage);
  }

  public getStorage() {
    if (localStorage.getItem(STORAGE) === 'local' || sessionStorage.getItem(STORAGE) === 'local') {
      return localStorage.getItem(STORAGE);
    } else {
      return sessionStorage.getItem(STORAGE);
    }
  }

  public setToken(token: string) {
    if (this.getStorage() === 'local') {
      localStorage.removeItem(TOKEN_KEY);
      localStorage.setItem(TOKEN_KEY, token);
    } else {
      sessionStorage.removeItem(TOKEN_KEY);
      sessionStorage.setItem(TOKEN_KEY, token);
    }
  }

  public getToken(): string {
    if (this.getStorage() === 'local') {
      return localStorage.getItem(TOKEN_KEY);
    } else {
      return sessionStorage.getItem(TOKEN_KEY);
    }
  }

  public setId(id: string) {
    if (this.getStorage() === 'local') {
      localStorage.removeItem(ID_KEY);
      localStorage.setItem(ID_KEY, id);
    } else {
      sessionStorage.removeItem(ID_KEY);
      sessionStorage.setItem(ID_KEY, id);
    }
  }

  public getId() {
    if (this.getStorage() === 'local') {
      return localStorage.getItem(ID_KEY);
    } else {
      return sessionStorage.getItem(ID_KEY);
    }
  }

  public setName(name: string) {
    if (this.getStorage() === 'local') {
      localStorage.removeItem(NAME_KEY);
      localStorage.setItem(NAME_KEY, name);
    } else {
      sessionStorage.removeItem(NAME_KEY);
      sessionStorage.setItem(NAME_KEY, name);
    }
  }

  public getName(): string {
    if (this.getStorage() === 'local') {
      return localStorage.getItem(NAME_KEY);
    } else {
      return sessionStorage.getItem(NAME_KEY);
    }
  }

  public setRole(role: string[]) {
    if (this.getStorage() === 'local') {
      localStorage.removeItem(ROLE_KEY);
      localStorage.setItem(ROLE_KEY, JSON.stringify(role));
    } else {
      sessionStorage.removeItem(ROLE_KEY);
      sessionStorage.setItem(ROLE_KEY, JSON.stringify(role));
    }
  }

  public getRole(): string {
    if (this.getStorage() === 'local') {
      const roles = JSON.parse(<string> localStorage.getItem(ROLE_KEY));
      return roles[0].authority;
    } else {
      const roles = JSON.parse(<string> sessionStorage.getItem(ROLE_KEY));
      return roles[0].authority;
    }
  }

  rememberMe(token, id, name, roles, storage) {
    this.setToken(token);
    this.setId(id);
    this.setName(name);
    this.setRole(roles);
    this.setStorage(storage);
  }

  public getCartSession() {
    const carts = sessionStorage.getItem(CART);
    this.cart = JSON.parse(carts);
    return this.cart;
  }

  public changeQuantitySession(operator: string, index: number) {
    let cart: Cart[] = this.getCartSession();
    if (operator == '-') {
      if (cart[index].quantity == 1) {
        cart.splice(index, 1);
      } else {
        cart[index].quantity = cart[index].quantity - 1;
      }
    } else {
      cart[index].quantity = cart[index].quantity + 1;
    }
    this.setCart(cart);
  }
  public setCart(cart: Cart[]) {
    sessionStorage.removeItem(CART);
    sessionStorage.setItem(CART, JSON.stringify(cart));
  }

  public deleteCartSessionIndex(index:number) {
    this.cart = this.getCartSession();
    this.cart.splice(index,1)
    this.setCart(this.cart);
  }
}
