package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Event;
import ua.lviv.iot.service.EventService;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImp implements EventService {
    @Autowired
    public EventDao eventDao;

    @Override
    public List<Event> findAll() {
        return eventDao.findAll();
    }

    @Override
    public Optional<Event> findById(Integer id) {
        return eventDao.findById(id);
    }

    @Override
    public int create(Event event) {
        return eventDao.create(event);
    }

    @Override
    public int update(Integer id, Event event) {
        return eventDao.update(id, event);
    }

    @Override
    public int delete(Integer id) {
        return eventDao.delete(id);
    }

    @Override
    public List<Event> getAllEventsByCityId(Integer id) {
        return eventDao.getAllEventsByCityId(id);
    }
}
