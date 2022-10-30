package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.City;
import ua.lviv.iot.dao.CityDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Optional;

@Service
public class CityDaoImp implements CityDao {
    public static final String FIND_ALL = "SELECT * FROM city";
    public static final String FIND_DY_ID = "SELECT * FROM city WHERE id=?";
    public static final String CREATE = "INSERT city(name, region_id) VALUES (?, ?)";
    public static final String DELETE = "DELETE FROM city WHERE id=?";
    public static final String UPDATE = "UPDATE city SET name=?, region_id=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<City> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(City.class));
    }

    @Override
    public Optional<City> findById(Integer id) {
        Optional<City> city;
        try {
            city = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_DY_ID, BeanPropertyRowMapper.newInstance(City.class), id));
        } catch (EmptyResultDataAccessException e) {
            city = Optional.empty();
        }
        return city;
    }

    @Override
    public int create(City city) {
        return jdbcTemplate.update(CREATE, city.getName(), city.getRegionId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, City city) {
        return jdbcTemplate.update(UPDATE, city.getName(), city.getRegionId(), id);
    }
}
