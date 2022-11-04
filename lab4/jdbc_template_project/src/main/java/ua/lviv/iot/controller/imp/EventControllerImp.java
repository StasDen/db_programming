package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Event;
import ua.lviv.iot.service.EventService;
import ua.lviv.iot.controller.EventController;

import java.util.List;
import java.util.Optional;

@Service
public class EventControllerImp implements EventController {
    @Autowired
    public EventService eventService;

    @Override
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @Override
    public Optional<Event> findById(Integer id) {
        return eventService.findById(id);
    }

    @Override
    public int create(Event event) {
        return eventService.create(event);
    }

    @Override
    public int delete(Integer id) {
        return eventService.delete(id);
    }

    @Override
    public int update(Integer id, Event event) {
        return eventService.update(id, event);
    }

    @Override
    public List<Event> getAllEventsByCityId(Integer id) {
        return eventService.getAllEventsByCityId(id);
    }
}
