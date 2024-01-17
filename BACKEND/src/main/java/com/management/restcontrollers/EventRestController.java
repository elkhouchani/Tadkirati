package com.management.restcontrollers;

import com.management.entities.Event;
import com.management.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EventRestController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<Event> getAllEvents() {return eventService.getAllEvents();}

    @GetMapping("/events/{eventId}")
    public Event getEventById(@PathVariable("eventId") Long eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping("/events/category/{idCategory}")
    public List<Event> getAllEventsByCategory(@PathVariable("categoryId") Long categoryId) {
        return eventService.findAllEventsByIdCategory(categoryId);
    }

    @PostMapping("/events/save")
    public Event createEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @PutMapping("/events/update")
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEventById(@PathVariable("eventId") Long eventId) {
        eventService.deleteEventById(eventId);
    }
}