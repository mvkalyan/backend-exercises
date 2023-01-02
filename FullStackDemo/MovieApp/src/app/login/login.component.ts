import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  userLoginFormData=new FormGroup({
    "userId":new FormControl(''),
    "userPassword":new FormControl("***")
  })

  responseData:any;

  loginCheck(){
    this.userService.loginUser(this.userLoginFormData.value).subscribe(
      rspns=>{
        console.log(rspns);
        this.responseData=rspns;
        localStorage.setItem('token',this.responseData.token);
        alert(localStorage.getItem('token'));
        alert("Login Successful");
      }
    )
  }

}
