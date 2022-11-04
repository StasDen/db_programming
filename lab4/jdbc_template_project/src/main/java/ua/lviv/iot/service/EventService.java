package ua.lviv.iot.service;

import ua.lviv.iot.domain.Event;

import java.util.List;

public interface EventService extends GeneralService<Event, Integer> {
    List<Event> getAllEventsByCityId(Integer id);
}
