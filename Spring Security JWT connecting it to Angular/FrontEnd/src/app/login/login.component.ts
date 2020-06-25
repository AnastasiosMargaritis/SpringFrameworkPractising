import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import {NgForm} from '@angular/forms';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  authRequest:any={
    "username" : "AnthiMl",
    "password" : "1234"
  };

  response:any;
  isError = false;
  errorMessage: string;

  constructor(private service: LoginService) { }

  ngOnInit() {

  }

  public getAccessToken(authRequest){
    this.service.generateToken(authRequest).subscribe(
      data=>{
        this.accessApi(data)
      }, error => {
        this.isError = true;
        this.errorMessage = error.message;
      });
  }


  public accessApi(token){
  this.service.welcome(token).subscribe(data => {
      console.log(data);
    }, error => {
      this.isError = true;
      this.errorMessage = error.message;

    });
  }

  public onLogin(form: NgForm){
    const value = form.value;
    this.username = value.username;
    this.password = value.password;

    this.authRequest = {
      "username" : this.username,
      "password" : this.password
    };

    this.getAccessToken(this.authRequest);
  }

}
