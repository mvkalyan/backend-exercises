import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PizzaService } from '../pizza.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  constructor(private userService:UserService,private pizzaService:PizzaService) { }

  ngOnInit(): void {
  }

  userLoginForm=new FormGroup({
    "userId":new FormControl(''),
    "userPassword":new FormControl('')
  });

  responseData:any;
  login(){
    this.userService.userLogin(this.userLoginForm.value).subscribe(
      response=>{
        this.responseData=response;
        localStorage.setItem("token",this.responseData.token);
        alert("Login Successful");
        this.userService.getUserEmail(this.userLoginForm.value.userId).subscribe(
          res=>{
            this.responseData=res;
            this.userService.userEmail=this.pizzaService.emailId=this.responseData.userEmail;
            alert("Welcome "+this.userService.userEmail);
          }
        )
      }
    )
  }
}
