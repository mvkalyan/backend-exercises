import { Component, OnInit } from '@angular/core';
import { PizzaService } from '../pizza.service';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {

  constructor(private pizzaService:PizzaService) {
      this.getPizzas();
      this.getUserPizza();
   }

  ngOnInit(): void {
  }

  pizzas:any;

  getPizzas(){
    this.pizzaService.getAllPizzas().subscribe(
      response=>{
        this.pizzas=response;
      }
    )
  }
  responseData:any;
  addToCart(pizza:any){
    let item={
      "pizzaId":pizza.pizzaId,
      "pizzaName":pizza.pizzaName,
      "pizzaSize":pizza.pizzaSize,
      "pizzaCost":pizza.pizzaCost
    }
    // alert(pizza.pizzaId);
    this.pizzaService.sendAPizza(pizza).subscribe(
      response=>{
        this.responseData=response;
        this.pizzaService.userPizza=this.responseData.userPizzaList;
        alert("Pizza added to Cart :)");
      }
    )
    // console.log(this.userPizza);
  }

  getUserPizza(){
    this.pizzaService.getUserPizzas().subscribe(
      response=>{
        this.responseData=response;
        this.pizzaService.userPizza=this.responseData.userPizzaList;
      })
  }

  deleteFromCart(p:any){
    // alert(p.pizzaId);
    this.pizzaService.deletePizza(p).subscribe(
      respo=>{
        alert("Pizza removed from cart");
        this.getUserPizza();
      }
    )
  }
}