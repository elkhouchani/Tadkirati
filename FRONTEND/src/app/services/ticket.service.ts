import { Injectable } from '@angular/core';
import { TicketModel} from "../models/ticket.model";
import {CategoryModel} from "../models/category.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {apiURL} from "../config";
import {AuthService} from "./auth.service";

const httpOptions = {
  headers : new HttpHeaders({
    'content-Type' : 'application/json'
  })

} ;

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  jwt = "Bearer"+ this.authService.getToken();
  httHeaders = new HttpHeaders({"Authorization":this.jwt})
  tickets : TicketModel[];
  ticket! : TicketModel;
  categories! : CategoryModel[];
  category! : CategoryModel;
  constructor( private http : HttpClient,private authService : AuthService){
    this.categories = []
    this.tickets = [];
  }
  ticketsList(){
    return this.http.get<TicketModel[]>(apiURL+"/tickets", {headers:this.httHeaders});
  }
  addTicket(newTicket : TicketModel){
    return this.http.post<TicketModel>(apiURL+"/tickets/save",newTicket,{headers:this.httHeaders});
  }
  deleteTicket(id : number){
    return this.http.delete(apiURL+"/tickets/"+id,{headers:this.httHeaders});
  }
  editticket(id:number){
    return this.http.get<TicketModel>(apiURL+"/tickets/"+id,{headers:this.httHeaders});
  }
  updateTicket(ticket : TicketModel){
    return this.http.put<TicketModel>(apiURL+"/tickets/update",ticket,{headers:this.httHeaders});
  }


  categoriesList(){
    return this.http.get<CategoryModel[]>(apiURL+"/categories",{headers:this.httHeaders});

  }

  editCategory(id:number){
    this.category = this.categories.find(e=>e.idCategory == id,{headers:this.httHeaders})!;
    return this.category;
  }
}
