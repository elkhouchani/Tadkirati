package com.management.services;

import com.management.entities.Event;
import com.management.entities.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    Ticket saveTicket(Ticket Ticket);
    Ticket updateTicket(Ticket Ticket);
    Ticket getTicketById(Long id);
    List<Ticket> getAllTickets();
    void deleteTicketById(Long id);




    List<Ticket> findAllTicketsByIdCategory(Long idCategory);




}