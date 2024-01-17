import { Component } from '@angular/core';

import {AuthService} from "../services/auth.service";
import {TicketModel} from "../models/ticket.model";
import {TicketService} from "../services/ticket.service";


@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent {
  tickets! : TicketModel[];
  constructor(private ticketService : TicketService , public authService : AuthService){
    ticketService.ticketsList().subscribe(p=>{
      // console.log(p);
      this.tickets =p ;
    })
    //this.tickets = ticketService.ticketsList();
  }

  loadTickets(){
    this.ticketService.ticketsList().subscribe(p=>{
      this.tickets = p ;
    })
  }


}
