import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, RequiredValidator, Validators } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-userregister',
  templateUrl: './userregister.component.html',
  styleUrls: ['./userregister.component.css']
})
export class UserregisterComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  userRegisterForm=new FormGroup({
    "email":new FormControl(''),
    "password":new FormControl(''),
    "name":new FormControl(''),
    "address":new FormControl('')
  });

  registerUser(){
    this.userService.userRegister(this.userRegisterForm.value).subscribe(
      response=>{
        alert("User registered Successfully");
        this.userService.getUserId(this.userRegisterForm.value.email).subscribe(
          res=>{
            alert("Please note your UserId: "+res);
          }
        )
      }
    )
  }

}
