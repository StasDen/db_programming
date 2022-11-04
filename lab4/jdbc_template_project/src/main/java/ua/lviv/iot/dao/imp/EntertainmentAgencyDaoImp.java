package ua.lviv.iot.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.EntertainmentAgency;
import ua.lviv.iot.dao.EntertainmentAgencyDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class EntertainmentAgencyDaoImp implements EntertainmentAgencyDao {
    public static final String FIND_ALL = "SELECT * FROM entertainment_agency";
    public static final String FIND_BY_ID = "SELECT * FROM entertainment_agency WHERE id=?";
    public static final String CREATE = "INSERT entertainment_agency(name, contact_number, address, animator_id, city_id) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE = "DELETE FROM entertainment_agency WHERE id=?";
    public static final String UPDATE = "UPDATE entertainment_agency SET name=?, contact_number=?, address=?, animator_id=?, city_id=? WHERE id=?";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<EntertainmentAgency> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(EntertainmentAgency.class));
    }

    @Override
    public Optional<EntertainmentAgency> findById(Integer id) {
        Optional<EntertainmentAgency> entertainmentAgency;

        try {
            entertainmentAgency = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(EntertainmentAgency.class), id));
        } catch (EmptyResultDataAccessException e) {
            entertainmentAgency = Optional.empty();
        }
        return entertainmentAgency;
    }

    @Override
    public int create(EntertainmentAgency entertainmentAgency) {
        return jdbcTemplate.update(CREATE, entertainmentAgency.getName(), entertainmentAgency.getContactNumber(), entertainmentAgency.getAddress(), entertainmentAgency.getAnimatorId(), entertainmentAgency.getCityId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public int update(Integer id, EntertainmentAgency entertainmentAgency) {
        return jdbcTemplate.update(UPDATE, entertainmentAgency.getName(), entertainmentAgency.getContactNumber(), entertainmentAgency.getAddress(), entertainmentAgency.getAnimatorId(), entertainmentAgency.getCityId(), id);
    }
}
