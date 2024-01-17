package com.management.services;




import com.management.entities.Ticket;

import com.management.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);}
    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }




    @Override
    public List<Ticket> findAllTicketsByIdCategory(Long idCategory) {
        return null;
    }


}