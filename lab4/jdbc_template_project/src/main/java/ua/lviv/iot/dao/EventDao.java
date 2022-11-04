package ua.lviv.iot.dao;

import ua.lviv.iot.domain.Event;

import java.util.List;

public interface EventDao extends GeneralDao<Event, Integer> {
    List<Event> getAllEventsByCityId(Integer id);
}
