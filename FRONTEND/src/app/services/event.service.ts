import { Injectable } from '@angular/core';
import {EventModel} from "../models/event.model";
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
export class EventService {
  jwt = "Bearer"+ this.authService.getToken();
  httHeaders = new HttpHeaders({"Authorization":this.jwt})
  events : EventModel[];
  event! : EventModel;
  categories! : CategoryModel[];
  category! : CategoryModel;
  constructor( private http : HttpClient,private authService : AuthService){
    this.categories = []
    this.events = [];
  }
  eventsList(){
  return this.http.get<EventModel[]>(apiURL+"/events", {headers:this.httHeaders});
  }
  addEvent(newEvent : EventModel){
   return this.http.post<EventModel>(apiURL+"/events/save",newEvent,{headers:this.httHeaders});
  }
  deleteEvent(id : number){
    return this.http.delete(apiURL+"/events/"+id,{headers:this.httHeaders});
  }
  editEvent(id:number){
    return this.http.get<EventModel>(apiURL+"/events/"+id,{headers:this.httHeaders});
  }
  updateEvent(event : EventModel){
  return this.http.put<EventModel>(apiURL+"/events/update",event,{headers:this.httHeaders});
  }


  categoriesList(){
    return this.http.get<CategoryModel[]>(apiURL+"/categories",{headers:this.httHeaders});

  }

  editCategory(id:number){
    this.category = this.categories.find(e=>e.idCategory == id,{headers:this.httHeaders})!;
    return this.category;
  }
}
