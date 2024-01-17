package com.management.restcontrollers;


import com.management.entities.Ticket;
import com.management.services.EventService;
import com.management.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TicketRestController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {return ticketService.getAllTickets();}

    @GetMapping("/tickets/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId") Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }


    @PostMapping("/tickets/save")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.saveTicket(ticket);
    }

    @PutMapping("/tickets/update")
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    @DeleteMapping("/tickets/{ticketId}")
    public void deleteTicketById(@PathVariable("ticketId") Long ticketId) {
        ticketService.deleteTicketById(ticketId);
    }
}