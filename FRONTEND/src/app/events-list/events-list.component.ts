import { Component } from '@angular/core';
import {EventModel} from "../models/event.model";
import {EventService} from "../services/event.service";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-events-list',
  templateUrl: './events-list.component.html',
  styleUrls: ['./events-list.component.css']
})
export class EventsListComponent {
  events! : EventModel[];
  constructor(private eventService : EventService , public authService : AuthService){
    eventService.eventsList().subscribe(p=>{
     // console.log(p);
    this.events =p ;
    })
    //this.events = eventService.eventsList();
  }
  deleteEvent(event : EventModel){
    let message = confirm("Are you sure you want to delete this event?");
    if(message)
    this.eventService.deleteEvent(event.eventId!).subscribe(()=>{
      this.loadEvents()
    });
  }
  loadEvents(){
    this.eventService.eventsList().subscribe(p=>{
      this.events = p ;
    })
  }
}
