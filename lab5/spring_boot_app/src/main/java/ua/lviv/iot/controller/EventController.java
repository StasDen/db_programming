package ua.lviv.iot.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Event;
import ua.lviv.iot.dto.EventDto;
import ua.lviv.iot.dto.assembler.EventDtoAssembler;
import ua.lviv.iot.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private EventDtoAssembler eventDtoAssembler;

    @GetMapping(value = "/{eventId}")
    public ResponseEntity<EventDto> getEvent(@PathVariable Integer eventId) {
        Event event = eventService.findById(eventId);
        EventDto eventDto = eventDtoAssembler.toModel(event);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<EventDto>> getAllEvents() {
        List<Event> events = eventService.findAll();
        CollectionModel<EventDto> eventsDto = eventDtoAssembler.toCollectionModel(events);
        return new ResponseEntity<>(eventsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<EventDto> addEvent(@RequestBody Event event) {
        Event newEvent = eventService.create(event);
        EventDto eventDto = eventDtoAssembler.toModel(newEvent);
        return new ResponseEntity<>(eventDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{eventId}")
    public ResponseEntity<?> updateEvent(@RequestBody Event uEvent, @PathVariable Integer eventId) {
        eventService.update(eventId, uEvent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Integer eventId) {
        eventService.delete(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
