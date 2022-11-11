package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.repository.EventRepository;
import ua.lviv.iot.service.EventService;
import ua.lviv.iot.domain.Event;
import ua.lviv.iot.exception.EventNotFoundException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class EventServiceImp implements EventService {
    @Autowired
    EventRepository eventRepository;

    public Event findById(Integer id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Transactional
    public Event create(Event event) {
        eventRepository.save(event);
        return event;
    }

    @Transactional
    public void update(Integer id, Event uEvent) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        event.setName(uEvent.getName());
        event.setAnimatorsNum(uEvent.getAnimatorsNum());
        event.setVisitorsNum(uEvent.getAnimatorsNum());
        event.setDate(uEvent.getDate());
        event.setAddress(uEvent.getAddress());
        event.setDurationInHours(uEvent.getDurationInHours());
        event.setCityId(uEvent.getCityId());
        eventRepository.save(event);
    }

    @Transactional
    public void delete(Integer id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        eventRepository.delete(event);
    }
}
