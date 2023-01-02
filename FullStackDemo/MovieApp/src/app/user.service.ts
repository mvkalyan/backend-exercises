import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  baseUrl:string="http://localhost:1234/user/v1/"

  addUser(user:any){
    return this.httpClient.post(this.baseUrl+"register",user)
  }

  loginUser(user:any){
    return this.httpClient.post(this.baseUrl+"login",user);
  }

  logoutUser(){
    localStorage.removeItem('token');
    console.log(localStorage.getItem('token'));
    alert("Logged out successfully");
  }
}