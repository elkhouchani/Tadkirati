import { Injectable } from '@angular/core';
import {UserModel} from "../models/user.model";
import {Router} from "@angular/router";
import {JwtHelperService} from "@auth0/angular-jwt";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  /*users : UserModel[] = [
    {username: "admin" , password : "123", roles : ['ADMIN','CREATE']},
    {username: "organizer" , password : "123", roles : ['ORGANIZER','CREATE']},
    {username: "client" , password : "123", roles : ['CLIENT']},
  ];*/

  private helper =new JwtHelperService();
  token! : string;
  public loggedUser! : string;
  public isloggedIn : boolean = false;
  public roles! : string[];

  constructor(private router : Router, private httpClient:HttpClient) { }
  login(user : UserModel ){
    return this.httpClient.post<UserModel>('http://localhost:8080/login',user,{observe:'response'});
  }

  saveToken(jwt : string){
    localStorage.setItem('jwt',jwt);
    this.token = jwt ;
    this.isloggedIn = true;
    this.decodedJWT();
  }
  decodedJWT(){
    if (this.token!=undefined){
      const decodedToken = this.helper.decodeToken(this.token);
      this.roles=decodedToken.roles;
      this.loggedUser = decodedToken.sub;
    }
  }
  /*
  SignIn(user : UserModel){
    let validUser : boolean = false;
    this.users.forEach(u=>{
      if(user.username==u.username && user.password==u.password){
        validUser = true;
        this.loggedUser = u.username!;
        this.isloggedIn = true;
        this.roles = u.roles!;
        localStorage.setItem('loggedUser',this.loggedUser);
        localStorage.setItem('isloggedIn',String(this.isloggedIn));

      }
    })
    return validUser;
  }
  */
  isCreate(){
    if(!this.roles)
      return false
    return ( this.roles.indexOf('CREATE')>-1);
  }
  isAdmin(){
    if(!this.roles)
      return false
    return ( this.roles.indexOf('ADMIN')>-1);
  }
  getToken(){
    return this.token;
  }
  logout(){
    this.loggedUser=undefined!;
    this.isloggedIn = false ;
    this.roles = undefined!;
    this.token = undefined!;
    localStorage.removeItem('jwt');
    this.router.navigate(['login']);
  }
  setLoggedUserLS(login : string){
    this.loggedUser = login;
    this.isloggedIn =true;
 //   this.getRoles(login);
  }
  loadToken(){
    this.token = localStorage.getItem('jwt')!;
    this.decodedJWT();
  }



  isTokenExpired(){
    return this.helper.isTokenExpired(this.token);
  }

  /*getRoles(username : string){
    this.users.forEach(u=>{
      if (u.username==username)
        this.roles = u.roles!;
    })
  }*/
}
