import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  authRequest:any={
    "username" : "AnthiMl",
    "password" : "1234"
  };

  response:any;

  constructor(private service: LoginService) { }

  ngOnInit() {
    this.getAccessToken(this.authRequest);
  }

  public getAccessToken(authRequest){
    let resp=this.service.generateToken(authRequest);
    resp.subscribe(data=>this.accessApi(data));
  }


  public accessApi(token){
    let resp=this.service.welcome(token);
    resp.subscribe(data=>this.response=data);
  }

}
