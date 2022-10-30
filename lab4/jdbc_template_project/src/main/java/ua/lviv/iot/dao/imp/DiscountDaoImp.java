package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.DiscountDao;
import ua.lviv.iot.domain.Discount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountDaoImp implements DiscountDao {
    public static final String FIND_ALL = "SELECT * FROM discount";
    public static final String FIND_BY_ID = "SELECT * FROM discount WHERE id=?";
    public static final String CREATE = "INSERT discount(name, percentage) VALUES (?, ?)";
    public static final String DELETE = "DELETE FROM discount WHERE id=?";
    public static final String UPDATE = "UPDATE discount SET name=?, percentage=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Discount> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Discount.class));
    }

    @Override
    public Optional<Discount> findById(Integer id) {
        Optional<Discount> discount;

        try {
            discount = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Discount.class), id));
        } catch (EmptyResultDataAccessException e) {
            discount = Optional.empty();
        }
        return discount;
    }

    @Override
    public int create(Discount discount) {
        return jdbcTemplate.update(CREATE, discount.getName(), discount.getPercentage());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, Discount discount) {
        return jdbcTemplate.update(UPDATE, discount.getName(), discount.getPercentage(), id);
    }
}
