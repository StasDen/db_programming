package ua.lviv.iot.controller;

import ua.lviv.iot.domain.Event;

import java.util.List;

public interface EventController extends GeneralController<Event, Integer> {
    List<Event> getAllEventsByCityId(Integer id);
}
