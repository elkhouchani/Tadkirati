package com.management.services;

import com.management.entities.Category;
import com.management.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventService {

    Event saveEvent(Event Event);
    Event updateEvent(Event Event);
    Event getEventById(Long id);
    List<Event> getAllEvents();
    void deleteEventById(Long id);




    List<Event> findAllEventsByIdCategory(Long idCategory);

}
