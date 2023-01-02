import { Component, OnInit } from '@angular/core';
import { PizzaService } from '../pizza.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private pizzaServ:PizzaService) {
    this.getUserPizza();
  }

  ngOnInit(): void {
  }

  userPizza:any;

  getUserPizza(){
    this.userPizza=this.pizzaServ.userPizza;
  }

  orderConfirm(){
    alert("Your Order is Confirmed :)");
  }

  res:any;
  
  clearCart(){
    this.pizzaServ.clearUserPizza().subscribe(
      re=>{
        this.res=re;
        this.userPizza=this.res.userPizzaList;
        alert("Cart is Empty");
      }
    )
  }
}
