package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.OrderDao;
import ua.lviv.iot.domain.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDaoImp implements OrderDao {
    public static final String FIND_ALL = "SELECT * FROM `order`";
    public static final String FIND_BY_ID = "SELECT * FROM `order` WHERE id=?";
    public static final String CREATE = "INSERT `order`(name, cost_in_usd, event_id, discount_id, client_id, entertainment_agency_id) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String DELETE = "DELETE FROM `order` WHERE id=?";
    public static final String UPDATE = "UPDATE `order` SET name=?, cost_in_usd=?, event_id=?, discount_id=?, client_id=?, entertainment_agency_id=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Order.class));
    }

    @Override
    public Optional<Order> findById(Integer id) {
        Optional<Order> order;

        try {
            order = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Order.class), id));
        } catch (EmptyResultDataAccessException e) {
            order = Optional.empty();
        }
        return order;
    }

    @Override
    public int create(Order order) {
        return jdbcTemplate.update(CREATE, order.getName(), order.getCostInUsd(), order.getEventId(), order.getDiscountId(), order.getClientId(), order.getEntertainmentAgencyId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, Order order) {
        return jdbcTemplate.update(UPDATE, order.getName(), order.getCostInUsd(), order.getEventId(), order.getDiscountId(), order.getClientId(), order.getEntertainmentAgencyId(), id);
    }
}
