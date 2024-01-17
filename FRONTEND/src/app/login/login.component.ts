import { Component } from '@angular/core';
import {UserModel} from "../models/user.model";
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  error : number = 0 ;
 user = new UserModel();
 constructor(private authService : AuthService,private router : Router) {
 }
  onLoggedin(){
  this.authService.login(this.user).subscribe({
    next :(data)=>{
      let jwtToken = data.headers.get("Authorization")!;
      this.authService.saveToken(jwtToken);
      this.router.navigate(['/']);
    },
    error: (error:any) => {
      this.error =1;
    }
  })

  }
}
