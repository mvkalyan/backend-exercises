import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }

  pizzaUserBaseUrl:string="http://localhost:1913/pizza-user/";
  userAuthBaseUrl:string="http://localhost:1912/userauth-app/v1/";
  userEmail:any;

  userRegister(commonUser:any){
    return this.httpClient.post(this.pizzaUserBaseUrl+"register",commonUser);
  }

  getUserId(userEmail:any){
    // http://localhost:1912/userauth-app/v1/get-userid/mk
      return this.httpClient.get(this.userAuthBaseUrl+"get-userid/"+userEmail);
  }

  userLogin(user:any){
    return this.httpClient.post(this.userAuthBaseUrl+"login",user);
  }

  getUserEmail(userId:any){
    return this.httpClient.get(this.userAuthBaseUrl+"get-emailid/"+userId)
  }
}
