import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  userSignupFormData=new FormGroup({
    "userPassword":new FormControl('*******'),
    "userEmail":new FormControl('abc@gmail.com')
  })

  registerUser(){
    this.userService.addUser(this.userSignupFormData.value).subscribe(
      respo=>{
        alert("User registered Successfully");
      }
    )
  }

}
