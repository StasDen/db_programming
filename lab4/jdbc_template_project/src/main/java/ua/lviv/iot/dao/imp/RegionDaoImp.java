package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.RegionDao;
import ua.lviv.iot.domain.Region;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class RegionDaoImp implements RegionDao {
    public static final String FIND_ALL = "SELECT * FROM region";
    public static final String FIND_BY_ID = "SELECT * FROM region WHERE id=?";
    public static final String CREATE = "INSERT region(name) VALUES (?)";
    public static final String DELETE = "DELETE FROM region WHERE id=?";
    public static final String UPDATE = "UPDATE region SET name=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Region> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Region.class));
    }

    @Override
    public Optional<Region> findById(Integer id) {
        Optional<Region> region;

        try {
            region = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Region.class), id));
        } catch (EmptyResultDataAccessException e) {
            region = Optional.empty();
        }
        return region;
    }

    @Override
    public int create(Region region) {
        return jdbcTemplate.update(CREATE, region.getName());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, Region region) {
        return jdbcTemplate.update(UPDATE, region.getName(), id);
    }
}
