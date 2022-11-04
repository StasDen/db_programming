package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.EventDao;
import ua.lviv.iot.domain.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class EventDaoImp implements EventDao {
    public static final String FIND_ALL = "SELECT * FROM event";
    public static final String FIND_BY_ID = "SELECT * FROM event WHERE id=?";
    public static final String CREATE = "INSERT event(name, animators_num, visitors_num, date, address, duration_in_hours, city_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE = "DELETE FROM event WHERE id=?";
    public static final String UPDATE = "UPDATE event SET name=?, animators_num=?, visitors_num=?, date=?, address=?, duration_in_hours=?, city_id=? WHERE id=?";
    public static final String GET_ALL_EVENTS_BY_CITY_ID = "SELECT * FROM event WHERE city_id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Event> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Event.class));
    }

    @Override
    public Optional<Event> findById(Integer id) {
        Optional<Event> event;

        try {
            event = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Event.class), id));
        } catch (EmptyResultDataAccessException e) {
            event = Optional.empty();
        }
        return event;
    }

    @Override
    public int create(Event event) {
        return jdbcTemplate.update(CREATE, event.getName(), event.getAnimatorsNum(), event.getVisitorsNum(), event.getDate(), event.getAddress(), event.getDurationInHours(), event.getCityId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, Event event) {
        return jdbcTemplate.update(UPDATE, event.getName(), event.getAnimatorsNum(), event.getVisitorsNum(), event.getDate(), event.getAddress(), event.getDurationInHours(), event.getCityId(), id);
    }

    @Override
    public List<Event> getAllEventsByCityId(Integer id) {
        return jdbcTemplate.query(GET_ALL_EVENTS_BY_CITY_ID, BeanPropertyRowMapper.newInstance(Event.class), id);
    }
}
