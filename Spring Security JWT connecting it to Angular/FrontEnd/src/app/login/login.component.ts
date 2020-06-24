import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  authRequest: any = {
    "username" : "AnthiMl",
    "password" : "1234"
  };

  constructor(private service: LoginService) { }

  ngOnInit() {

    this.getAccessToken(this.authRequest);
  }

  public getAccessToken(authRequest){
    this.service.generateToken(authRequest).subscribe(data => {
      console.log("Token: " + data);
    });
  }

}
