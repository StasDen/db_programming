package ua.lviv.iot.dao;

import ua.lviv.iot.domain.Event;

import java.util.List;

public interface EventDao extends GeneralDao<Event, Integer> {
    // Integer getVisitorsNumByEventName(String name);

    // List<Event> getAllEventsByCityId(Integer id);
}
