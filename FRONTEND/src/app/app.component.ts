import { Component } from '@angular/core';
import {AuthService} from "./services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FRONTEND';

  constructor(public authService : AuthService,private router : Router) {
    let loggedUser :string ;
    let isloggedIn : string ;
    loggedUser = localStorage.getItem('loggedUser')!;
    isloggedIn = localStorage.getItem('isloggedIn')!;
    if(!loggedUser || isloggedIn  == "false")
      router.navigate(['login'])
    else
      authService.setLoggedUserLS(loggedUser);

  }
  logout(){
    this.authService.logout();
  }
  ngOnInit(){
    this.authService.loadToken();
    if(this.authService.getToken()==null || this.authService.isTokenExpired())
      this.router.navigate(['/login']);
  }
}
