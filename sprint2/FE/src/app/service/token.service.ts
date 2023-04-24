import {Injectable} from '@angular/core';

const TOKEN_KEY = 'Token_Key';
const NAME_KEY = 'Name_Key';
const ROLE_KEY = 'Role_key';
const STORAGE = 'Storage_key';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  username: string;
  constructor() {
  }

  isLogined() {
    return !!this.getToken();
  }

  signOut() {
    window.localStorage.clear();
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
      let roles = JSON.parse(<string> localStorage.getItem(ROLE_KEY));
      return roles[0].authority;
    } else {
      let roles = JSON.parse(<string> sessionStorage.getItem(ROLE_KEY));
      return roles[0].authority;
    }
  }

  rememberMe(token, name, roles, storage) {
    this.setToken(token);
    this.setName(name);
    this.setRole(roles);
    this.setStorage(storage);
  }
}
