import { Component } from '@angular/core';
import { PizzaService } from './pizza.service';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PizzaApp';

  constructor(private pizzaService:PizzaService,private userservice:UserService){}

  logout(){
    this.pizzaService.emailId=this.userservice.userEmail=null;
    alert("Logged Out Successfully");
  }
}
