import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  constructor(private httpClient:HttpClient) { }

  baseUrl:string="http://localhost:1913/pizza-app/";
  pizzaUserBaseUrl:string="http://localhost:1913/pizza-user/";
  emailId:any;
  userPizza:any;

  getAllPizzas(){
    return this.httpClient.get(this.baseUrl+"pizzas");
  }

  sendAPizza(pizza:any){
    return this.httpClient.post(this.pizzaUserBaseUrl+"add-pizza/"+this.emailId,pizza);
  }

  getUserPizzas(){
    return this.httpClient.get(this.pizzaUserBaseUrl+"get-user-pizza/"+this.emailId)
  }

  clearUserPizza(){
    let httpHeaders = new HttpHeaders({
      "authorization":'Bearer '+localStorage.getItem('token')
    });
    // console.log(localStorage.getItem('token'));
    let requestOptions={headers:httpHeaders};
    return this.httpClient.delete(this.pizzaUserBaseUrl+"clear-cart/"+this.emailId,requestOptions);
  }

  deletePizza(p:any){
    let httpHeaders = new HttpHeaders({
      "authorization":'Bearer '+localStorage.getItem('token')
    });
    // console.log(localStorage.getItem('token'));
    let requestOptions={headers:httpHeaders};
    return this.httpClient.delete(this.pizzaUserBaseUrl+"delete-item/"+this.emailId+"/"+p.pizzaId,requestOptions);
    // return this.httpClient.delete("http://localhost:1913/pizza-user/delete-item/gk/101")
  }
}
